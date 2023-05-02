import java.util.concurrent.locks.ReentrantLock;

public class Casher {
	private Future future = new Future();

	public Pizza order() {
		System.out.println("An order is made.");
		new Thread(() -> {
			RealPizza realPizza = new RealPizza();
			future.setRealPizza(realPizza);
		}).start();
		return future;
	}

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Casher casher = new Casher();
		System.out.println("Ordering pizzas at a casher counter.");
		Pizza p1 = casher.order();
		Pizza p2 = casher.order();
		Pizza p3 = casher.order();
		Pizza p4 = casher.order();

		Thread thread = new Thread(() -> {
			try {
				((Future) p4).getPizza(1000);
			} catch (Exception e) {
				System.out.println("The customer who ordered pizza 4 said: "+e.getMessage());
			}
		});
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e1) {
		}
		
		while (true) {
			lock.lock();
			try {

				System.out.println("Let's see if pizzas are ready to pick up...");
				if (casher.future.isReady()) {
					System.out.println(p1.getPizza());
					System.out.println(p2.getPizza());
					System.out.println(p3.getPizza());
					break;
				}
				System.out.println("Doing something, reading newspapers, magazines, etc., "
						+ "until pizzas are ready to pick up...");

				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

		//
		// try{
		// Thread.sleep(2000);
		// }
		// catch(InterruptedException e){}
		//
		// System.out.println( p1.getPizza() );
		// System.out.println( p2.getPizza() );
		// System.out.println( p3.getPizza() );
	}
}
