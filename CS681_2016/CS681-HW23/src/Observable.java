import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Observable {

	public ArrayList<Observer> observers;
	private boolean changed;
	private ReentrantLock lock;

	public Observable() {
		observers = new ArrayList<Observer>();
		lock = new ReentrantLock();
		changed = false;
	}

	public void addObserver(Observer observer) {
		lock.lock();
		try {
			if (!this.observers.contains(observer)) {
				this.observers.add(observer);
				System.out.println("add observer");
			}
		} finally {
			lock.unlock();
		}
	}

	public void deleteObserver(Observer observer) {
		lock.lock();
		try {
			if (observers.contains(observer)) {
				this.observers.remove(observer);
				System.out.println(observers.size());
			}
		} finally {
			lock.unlock();
		}
	}

	public void setChanged() {
		lock.lock();
		this.changed = true;
		lock.unlock();
	}

	public boolean hasChanged() {
		return this.changed;
	}

	public void clearChanged() {
		lock.lock();
		this.changed = false;
		lock.unlock();
	}

	public void notifyObservers() {
		notifyObservers(null);
	}

	public void notifyObservers(Object arg) {
		Object[] arrLocal;
		lock.lock();
		if (!hasChanged()) {
			lock.unlock();
			return;
		}
		arrLocal = observers.toArray();
		clearChanged();
		lock.unlock();
		for (Object o : arrLocal) {
			((Observer) o).update(this, arg);
		}
	}

}
