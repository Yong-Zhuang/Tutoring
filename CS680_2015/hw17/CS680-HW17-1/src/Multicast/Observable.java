package Multicast;

import java.util.*;

public abstract class Observable<T> {

	public ArrayList<Observer<T>> observers;
	private boolean changed;

	public Observable() {
		observers = new ArrayList<Observer<T>>();
		changed = false;
	}

	public void addObserver(Observer<T> observer) {
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

	public void notifyObservers() throws IllegalArgumentException, IllegalAccessException {
		notifyObservers(null);
	}

	public void notifyObservers(T arg) throws IllegalArgumentException, IllegalAccessException {
		if (hasChanged()) {
			for (Observer<T> o : this.observers) {
				o.update(arg);
			}
			clearChanged();
		}
	}

}
