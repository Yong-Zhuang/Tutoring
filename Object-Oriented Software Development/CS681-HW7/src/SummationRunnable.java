import java.util.concurrent.locks.ReentrantLock;

public class SummationRunnable implements Runnable{
	private int upperBound;
	private boolean done = false;
	private ReentrantLock lock;
	public SummationRunnable(int n){
		upperBound = n;
		lock = new ReentrantLock();
	}

	public void setDone(){
		lock.lock();
		try{
			done = true;
		}
		finally{
			lock.unlock();
		}
	}

	public void run(){
		try{
			while( true ){
				lock.lock();
				try{
					if(done)
					{
						break;
					}
					System.out.println(Thread.currentThread().getName()+": "+upperBound);
					upperBound--;
					if( upperBound<0 ){
						System.out.println("print done");
						return;
					}
				}
				finally{
					lock.unlock();
					Thread.sleep(1000);
				}
			}
			if(upperBound>=0)
				System.out.println("stopped by main()!");
			done = false;
		} catch (InterruptedException e){
			System.out.println(e.getMessage());}
	}

	public static void main(String[] args){
		SummationRunnable sRunnable = new SummationRunnable(30);
		Thread thread1 = new Thread(sRunnable);
		Thread thread2 = new Thread(sRunnable);
		thread1.start();
		for(int i=0; i<5; i++){
			System.out.println("#");
		}
		sRunnable.setDone();
		try{
			thread1.join();
			thread2.start();
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
}
