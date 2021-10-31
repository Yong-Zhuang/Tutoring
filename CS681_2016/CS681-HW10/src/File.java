import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class File {
	private boolean changed;
	private ReentrantLock lock;

	public File() {
		this.changed = false;
		this.lock = new ReentrantLock();
	}
	public void change(){
		lock.lock();
		try{
			Date now = new Date();
			System.out.println( Thread.currentThread().getName()+": File has been changed at "+ now);
			this.changed = true;
		}
		finally{
			lock.unlock();
		}
	}
	public void save()
	{
		lock.lock();
		try{
			if (changed==false) {
				return; // balking
			}
			else{
				Date now = new Date();
				System.out.println(Thread.currentThread().getName()+": File has been saved at "+ now);
				this.changed = false;
			}
		}
		finally{
			lock.unlock();
		}
	}
}
