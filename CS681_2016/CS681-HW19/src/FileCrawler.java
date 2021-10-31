import java.util.concurrent.locks.ReentrantLock;

public class FileCrawler implements Runnable {

	private Directory dir;
	private FileQueue filequeue;
	private boolean flag;
	public ReentrantLock lock;

	public FileCrawler(Directory dir, FileQueue filequeue) {

		this.dir = dir;
		this.filequeue = filequeue;
		this.flag = false;
		this.lock = new ReentrantLock();
	}

	public void setDone() {
		lock.lock();
		try {
			flag = true;
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		crawl(this.dir);
	}

	public void crawl(Directory dir) {
		// dir.getChildren().forEach((FSElement fs) -> {
		//
		// });
		for (int i = 0; i < dir.getChildren().size(); i++) {
			try {
				lock.lock();
				if (flag) {
					System.out.println("Thread(crawler) "
							+ Thread.currentThread().getId() + " stop by main");
					return;
				}
				lock.unlock();
				FSElement fs = dir.getChildren().get(i);
				if (fs instanceof File) {
					System.out.println("Thread: "
							+ Thread.currentThread().getId() + " crawl file "
							+ fs.getName());

					filequeue.put((File) fs);

				}
				if (fs instanceof Directory) {
					crawl((Directory) fs);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread(indexer) "
						+ Thread.currentThread().getId()
						+ " is being stopped due to an InterruptedException.");
				continue;
			}
		}

	}

}
