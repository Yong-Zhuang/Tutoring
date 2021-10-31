import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable {

	private CopyOnWriteArrayList<Observer> observers;
	private boolean changed;
	private ReentrantLock lock;
	public Observable() {
		observers = new CopyOnWriteArrayList<Observer>();
		changed = false;
		lock=new ReentrantLock();
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void setChanged() {
		this.changed = true;
	}

	public boolean hasChanged() {
		return this.changed;
	}

	public void clearChanged() {
		this.changed = false;
	}

	public void notifyObservers() {		
		notifyObservers(null);
	}

	public void notifyObservers(Object arg) {
		lock.lock();
		if (!changed) {
			lock.unlock();
			return;
		}
		clearChanged();
		lock.unlock();
	
		Iterator<Observer> it = observers.iterator();
		while( it.hasNext() ){

			it.next().update(this, arg);

		}
	}

}
