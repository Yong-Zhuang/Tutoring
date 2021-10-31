
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Future implements Pizza {
	private RealPizza realPizza = null;
	private ReentrantLock lock;
	private Condition ready;
	private boolean isReady;

	public Future() {
		lock = new ReentrantLock();
		ready = lock.newCondition();
		isReady = false;
	}

	public void setRealPizza(RealPizza real) {
		lock.lock();
		try {
			if (realPizza != null) {
				return;
			}
			realPizza = real;
			isReady = true;
			ready.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public boolean isReady() {
		lock.lock();
		try {
			return isReady;
		} finally {
			lock.unlock();
		}
	}

	public String getPizza() {
		try {
			return getPizza(10000);
		} catch (TimeoutException | InterruptedException e) {
			return e.getMessage();
		}
	}

	public String getPizza(long timeout) throws TimeoutException, InterruptedException {
		String pizzaData = null;
		lock.lock();
		try {
			if (realPizza == null) {
				System.out.println("I am waiting pizza.");
				if (!ready.await(timeout, TimeUnit.MILLISECONDS)) {
					throw new TimeoutException("I am waiting for a long time, so I give up!");
				}
			}
			pizzaData = realPizza.getPizza();
		} finally {
			lock.unlock();
		}
		return pizzaData;
	}
}
