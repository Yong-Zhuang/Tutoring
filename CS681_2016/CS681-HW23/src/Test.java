import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Observable observable = new Observable();
		// observable.setChanged();
		// observable.addObserver((Observable o, Object
		// obj)->{System.out.println(obj);});
		// observable.notifyObservers("Hello World!");
		//
		//
		ArrayList<Thread> threads = new ArrayList<Thread>();

		 Thread t1 = new Thread(()-> {observable.addObserver((Observable o, Object obj)->{System.out.println("Thread 1 "+obj);});});
		 threads.add(t1);
		 t1.start();
		 Thread t2 = new Thread(()-> {observable.addObserver((Observable o, Object obj)->{System.out.println("Thread 2 "+obj);});});
		 threads.add(t2);
		 t2.start();
		 Thread t3 = new Thread(()-> {observable.addObserver((Observable o, Object obj)->{System.out.println("Thread 3 "+obj);});});
		 threads.add(t3);
		 t3.start();

		threads.forEach((Thread t) -> {
			try {
				t.join();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		observable.setChanged();
		observable.notifyObservers("Hello World!");
	}
}
