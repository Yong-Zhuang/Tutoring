import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Date;

public abstract class FileCache {
	protected HashMap<Path, String> map_content;
	protected HashMap<Path, Date> map_tstamp;
	private int threshold;
	private ReentrantLock lock;
	protected AccessCounter map_counter;

	public FileCache(int threshold,AccessCounter counter, ReentrantLock lock) {
		this.lock = lock;
		this.threshold = threshold;
		map_content = new HashMap<Path, String>();
		map_tstamp = new HashMap<Path, Date>();
		map_counter = counter;
	}

	public String fetch(Path path) {
		try {
			lock.lock();
			String content = null;
			if (!map_content.containsKey(path)) {
				content = cacheFile(path);
				System.out.println(Thread.currentThread().getName() + ": Call fetch & cacheFile, path: " + path + " content: "+ content);
				
			}
			if (content == null) {
				
				content = map_content.get(path);System.out.println(Thread.currentThread().getName() + ": Call fetch only, path: " + path + " content: "+ content);
				
			}
			Date date = new Date();
			map_tstamp.replace(path, date); 
			return content;
		} finally {
			lock.unlock();
		}
	}

	private String cacheFile(Path path) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (content == null) {
			return "";
		}
		if (map_content.size() > threshold) {
			replace(path);
		}
		map_content.put(path, content);
		map_tstamp.put(path, (new Date()));
		return content;
	}

	protected abstract void replace(Path path); // replace content, tstamp.
}
