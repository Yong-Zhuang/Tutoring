import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.locks.*;

public final class StaticThreadPool {
	private boolean debug = false;
	private Queue queue = null;
	private Vector<ThreadPoolThread> availableThreads = null;
	private static StaticThreadPool instance = null;
	private static ReentrantLock lock = new ReentrantLock();

	private StaticThreadPool(int maxThreadNum, boolean debug, String queueType) {
		this.debug = debug;
		switch (queueType) {
		case "array": {
			queue = new ArrayListQueue(this);
			break;
		}
		default: {
			queue = new WaitingRunnableQueue(this);
			break;
		}
		}
		availableThreads = new Vector<ThreadPoolThread>();
		for (int i = 0; i < maxThreadNum; i++) {
			ThreadPoolThread th = new ThreadPoolThread(this, queue, i);
			availableThreads.add(th);
			th.start();
		}
	}

	public static StaticThreadPool getInstance(int maxThreadNum, boolean debug, String queueType) {
		{
			lock.lock();
			try {
				if (instance == null) {
					instance = new StaticThreadPool(maxThreadNum, debug, queueType);
				}
				// System.out.println(instance);
				return instance;
			} finally {
				lock.unlock();
			}
		}

	}

	public void execute(Runnable runnable) {
		queue.put(runnable);
	}

	public int getWaitingRunnableQueueSize() {
		return queue.size();
	}

	public int getThreadPoolSize() {
		return availableThreads.size();
	}

	public void shutdown() {
		availableThreads.forEach((ThreadPoolThread tpt) -> {
			tpt.interrupt();
			tpt.setStopped();
		});
		System.out.println("all thread are terminated by main thread");
	}

	private class WaitingRunnableQueue implements Queue {
		private Vector<Runnable> runnables = new Vector<Runnable>();
		private StaticThreadPool pool;
		private ReentrantLock queueLock;
		private Condition runnablesAvailable;

		public WaitingRunnableQueue(StaticThreadPool pool) {
			this.pool = pool;
			queueLock = new ReentrantLock();
			runnablesAvailable = queueLock.newCondition();
		}

		public int size() {
			queueLock.lock();
			try {
				return runnables.size();
			} finally {
				queueLock.unlock();
			}
		}

		public void put(Runnable obj) {
			queueLock.lock();
			try {
				runnables.add(obj);
				if (pool.debug == true)
					System.out.println("A runnable queued.");
				runnablesAvailable.signalAll();
			} finally {
				queueLock.unlock();
			}
		}

		public Runnable get() {
			queueLock.lock();
			try {
				while (runnables.isEmpty()) {
					if (pool.debug == true)
						System.out.println("Waiting for a runnable...");
					runnablesAvailable.await();
				}
				if (pool.debug == true)
					System.out.println("A runnable dequeued.");
				return runnables.remove(0);
			} catch (InterruptedException ex) {
				return null;
			} finally {
				queueLock.unlock();
			}
		}
	}

	private class ArrayListQueue implements Queue {
		private ArrayList<Runnable> runnables = new ArrayList<Runnable>();
		private StaticThreadPool pool;
		private ReentrantLock queueLock;
		private Condition runnablesAvailable;

		public ArrayListQueue(StaticThreadPool pool) {
			this.pool = pool;
			queueLock = new ReentrantLock();
			runnablesAvailable = queueLock.newCondition();
		}

		public int size() {
			queueLock.lock();
			int size = runnables.size();
			queueLock.unlock();
			return size;
		}

		public void put(Runnable obj) {
			queueLock.lock();
			try {
				runnables.add(obj);
				if (pool.debug == true)
					System.out.println("A runnable queued.");
				runnablesAvailable.signalAll();
			} finally {
				queueLock.unlock();
			}
		}

		public Runnable get() {
			queueLock.lock();
			try {
				while (runnables.isEmpty()) {
					if (pool.debug == true)
						System.out.println("Waiting for a runnable...");
					runnablesAvailable.await();
				}
				if (pool.debug == true)
					System.out.println("A runnable dequeued.");
				return runnables.remove(0);
			} catch (InterruptedException ex) {
				return null;
			} finally {
				queueLock.unlock();
			}
		}
	}

	private class ThreadPoolThread extends Thread {
		private StaticThreadPool pool;
		private Queue queue;
		private int id;
		private boolean stopped = false;
		private ReentrantLock lock;

		public ThreadPoolThread(StaticThreadPool pool, Queue queue, int id) {
			this.pool = pool;
			this.queue = queue;
			this.id = id;
			this.lock = new ReentrantLock();
		}

		public void setStopped() {
			lock.lock();
			try {
				stopped = true;
			} finally {
				lock.unlock();
			}
		}

		public void run() {
			if (pool.debug == true)
				System.out.println("Thread " + id + " starts.");
			while (true) {
				lock.lock();
				try {
					if (stopped) {
						break;
					}
					Runnable runnable = queue.get();
					if (runnable == null) {
						if (pool.debug == true)
							System.out
									.println("Thread " + this.id + " is being stopped due to an InterruptedException.");
						break;
					} else {
						if (pool.debug == true)
							System.out.println("Thread " + id + " executes a runnable.");
						runnable.run();
						if (pool.debug == true)
							System.out.println("ThreadPoolThread " + id + " finishes executing a runnable.");
					}
				} finally {
					lock.unlock();
				}
			}
			// if(pool.debug==true) System.out.println("Thread " + id + "
			// stops.");
		}
	}

	public static void main(String[] args) {
		StaticThreadPool pool = new StaticThreadPool(2, true, "array");
		pool.execute(new RunnableTest("a"));
		pool.execute(new RunnableTest("b"));
		pool.execute(new RunnableTest("c"));
		pool.execute(new RunnableTest("d"));
		try {
			Thread.sleep(500);
			System.out.println("Main thread sleeps 5 seconds.");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		pool.shutdown();
	}
}
