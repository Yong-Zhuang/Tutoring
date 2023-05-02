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

	public void increment(String filename) {
		lock.writeLock().lock();
		int count = 1;
		try {
			if (accessCounterTable.containsKey(filename)) {
				count = accessCounterTable.get(filename) + 1;
			}
		} finally {
			accessCounterTable.put(filename, count);
			System.out.println(
					Thread.currentThread().getName() + ": Call increment, fileName: " + filename + " count: " + count + " times.");
			lock.writeLock().unlock();
		}
	}

	public int getCount(String filename) {
		lock.readLock().lock();
		int count = 0;
		try {
			if (accessCounterTable.containsKey(filename)) {
				count = accessCounterTable.get(filename);
			}
		} finally {
			System.out.println(
					Thread.currentThread().getName() + ": Call getCount, fileName: " + filename + " count: " + count + " times.");
			lock.readLock().unlock();
		}
		return count;
	}

}
