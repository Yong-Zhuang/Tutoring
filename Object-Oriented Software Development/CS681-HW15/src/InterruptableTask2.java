
import java.util.concurrent.locks.ReentrantLock;

public class InterruptableTask2 implements Runnable{
	private ReentrantLock lock;
	public InterruptableTask2(ReentrantLock lock)
	{
		this.lock=lock;
	}
	public void run(){
		while(true){
			lock.lock();
			if(Thread.interrupted()) break; // balking
			System.out.println(1);
			lock.unlock();
		}
		System.out.println(4);
	}
	
	public static void main(String[] args){
		ReentrantLock lock = new ReentrantLock();
		Thread t = new Thread(new InterruptableTask2(lock));
		t.start();
		try
		{
			Thread.sleep(2000);
			lock.lock();
			t.interrupt();
			lock.unlock();
		} catch (InterruptedException e){}
	}
}
