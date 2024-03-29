
import java.util.ArrayList;
import java.util.Random;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Random r = new Random(20);
		PiechartObserver pieObserver = new PiechartObserver();
		TableObserver tableObserver = new TableObserver();
		ThreeDObserver threeDObserver = new ThreeDObserver();
		StockQuoteObservable stock = new StockQuoteObservable();

		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		Thread t1 = new Thread(()-> {stock.addObserver(pieObserver);});
		t1.start();
		threads.add(t1);
		Thread t2 = new Thread(()-> {stock.addObserver(tableObserver);});
		t2.start();
		threads.add(t2);
		Thread t3 = new Thread(()-> {stock.addObserver(threeDObserver);});
		t3.start();
		threads.add(t3);
		float quote = 0;
		int i=0;
		while (i<5) {

			quote = r.nextFloat() * 20;

			stock.changeQuote(quote, "Microsoft Stock");

            Thread.sleep(2000);   
            i++;
		}
	}
}
