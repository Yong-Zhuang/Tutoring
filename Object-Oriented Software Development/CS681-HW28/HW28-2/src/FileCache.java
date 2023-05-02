import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.Date;

public abstract class FileCache {
	protected HashMap<String, byte[]> map_content;
	protected HashMap<String, Date> map_tstamp;
	private int threshold;
	private ReentrantReadWriteLock lock;
	protected AccessCounter map_counter;

	public FileCache(int threshold, AccessCounter counter,
			ReentrantReadWriteLock lock) {
		this.lock = lock;
		this.threshold = threshold;
		map_content = new HashMap<String, byte[]>();
		map_tstamp = new HashMap<String, Date>();
		map_counter = counter;
	}

	public byte[] fetch(File file, DataInputStream fin) {
		try {
			lock.writeLock().lock();
			byte[] content = null;
			if (!map_content.containsKey(file.getName())) {
				content = cacheFile(file, fin);
				System.out.println(Thread.currentThread().getName()
						+ ": Call fetch & cacheFile, fileName: "+file.getName());

			}
			lock.readLock().lock();
			lock.writeLock().unlock();

			if (content == null) {
				content = map_content.get(file.getName());
				System.out.println(Thread.currentThread().getName()
						+ ": Call fetch only, fileName: "+file.getName());

			}
			Date date = new Date();
			map_tstamp.replace(file.getName(), date);

			return content;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			lock.readLock().unlock();
		}
		return null;
	}

	private byte[] cacheFile(File file, DataInputStream fin) {
		int len = (int) file.length();
		byte buf[] = new byte[len];
		try {
			fin.readFully(buf);
			;

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (map_content.size() > threshold) {
			replace(file.getName());
		}
		map_content.put(file.getName(), buf);
		map_tstamp.put(file.getName(), (new Date()));
		return buf;
	}

	protected abstract void replace(String fileName); // replace content,
														// tstamp.
}
