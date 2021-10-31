

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Observable observable = new Observable();
		observable.setChanged();
		observable.addObserver((Observable o, Object obj)->{System.out.println(obj);});
		observable.notifyObservers("Hello World!");
	}
}
