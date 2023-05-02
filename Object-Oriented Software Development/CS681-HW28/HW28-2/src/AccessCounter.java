import java.nio.file.*;
import java.io.File;
import java.lang.Integer;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccessCounter {

	public HashMap<String, Integer> accessCounterTable = new HashMap<>();
	private ReentrantReadWriteLock lock;

	public AccessCounter(ReentrantReadWriteLock lock) {
		this.lock = lock;
		this.accessCounterTable = new HashMap<String, Integer>();
	}

	public void increment(File file) {
		lock.writeLock().lock();
		int count = 1;
		try {
			if (accessCounterTable.containsKey(file.getName())) {
				count = accessCounterTable.get(file.getName()) + 1;
			}
		} finally {
			accessCounterTable.put(file.getName(), count);
			System.out.println(
					Thread.currentThread().getName() + ": Call increment, fileName: " + file.getName() + " count: " + count + " times.");
			lock.writeLock().unlock();
		}
	}

	public int getCount(File file) {
		lock.readLock().lock();
		int count = 0;
		try {
			if (accessCounterTable.containsKey(file.getName())) {
				count = accessCounterTable.get(file.getName());
			}
		} finally {
			System.out.println(
					Thread.currentThread().getName() + ": Call getCount, fileName: " + file.getName() + " count: " + count + " times.");
			lock.readLock().unlock();
		}
		return count;
	}

}
