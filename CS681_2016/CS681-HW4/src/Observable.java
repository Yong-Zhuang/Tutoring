

import java.util.*;

public class Observable {

	public ArrayList<Observer> observers;
	private boolean changed;

	public Observable() {
		observers = new ArrayList<Observer>();
		changed = false;
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	public void deleteObserver(Observer observer) {
		this.observers.remove(observer);
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
		if (hasChanged()) {
			for (Observer o : this.observers) {
				o.update(this, arg);
			}
			clearChanged();
		}
	}

}
