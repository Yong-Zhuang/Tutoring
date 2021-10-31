import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class SecurityGate {
	private AtomicInteger counter = new AtomicInteger(0);	
	private static SecurityGate instance = null;
	private SecurityGate(){}
	public static SecurityGate getInstance() {
		if (instance == null) {
			instance = new SecurityGate();
			return instance;
		}
		return instance;
	}
	public void enter(){
		
		System.out.println(Thread.currentThread().getName()+" enter and value: "+counter.incrementAndGet());
	}
	public void exit(){
		System.out.println(Thread.currentThread().getName()+" exit and value: "+counter.decrementAndGet());
	}
	public int getCount(){
		return this.counter.get();
	}
}