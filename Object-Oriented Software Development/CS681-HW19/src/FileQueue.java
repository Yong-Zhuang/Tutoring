import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class FileQueue {

	private ArrayList<File> fileQueue;
	private ReentrantLock lock;
	private Condition notFull, notEmpty;
	private int maxSize;

	public FileQueue(int maxSize) {
		fileQueue = new ArrayList<File>();
		lock = new ReentrantLock();
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
		this.maxSize = maxSize;
	}

	public void put(File file) throws InterruptedException {
		lock.lock();
		try {
			if (fileQueue.size() >= maxSize) {
				notFull.await();
			}
			fileQueue.add(file);
			notEmpty.signal();
		} finally {
			lock.unlock();
		}

	}

	public File get() {
		File f = null;
		lock.lock();
		try {
			while (fileQueue.size() <= 0) {
				notEmpty.await();
			}
			if (fileQueue.size() > 0) {
				f = fileQueue.remove(0);
			}
			notFull.signal();
			return f;
		} catch (InterruptedException e) {
			return null;
		} finally {
			lock.unlock();
		}
	}
}