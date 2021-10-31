import java.util.concurrent.locks.ReentrantLock;

public class FileIndexer implements Runnable {

	private FileQueue filequeue;
	private boolean flag;
	public ReentrantLock lock;

	public FileIndexer(FileQueue filequeue) {
		this.filequeue = filequeue;
		this.flag = false;
		this.lock = new ReentrantLock();
	}

	// every indexer and crawler should has its own lock for main thread change
	// the flag,
	// thus indexers and crawler can work parallel,
	// every indexer or crawler's lock won't affect other thread.
	public void setDone() {
		lock.lock();
		try {
			flag = true;
		} finally {
			lock.unlock();
			// System.out.println("FileIndexer is setted done by main");
		}
	}

	public void run() {
		while (true) {
			lock.lock();
			if (flag) {
				System.out.println("Thread(indexer) "
						+ Thread.currentThread().getId() + " stop by main");
				break;
			}
			lock.unlock();
			File f = filequeue.get();
			if (f == null) {
				System.out.println("Thread(indexer) "
						+ Thread.currentThread().getId()  + " is being stopped due to an InterruptedException.");
				continue;
			} else {
				indexFile(f);
			}
		}
	}

	public void indexFile(File file) {

		System.out.println("Thread " + Thread.currentThread().getId()
				+ " index File " + file.getName());
	}

}