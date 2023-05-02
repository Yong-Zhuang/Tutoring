package Multicast;

import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws InterruptedException, IllegalArgumentException, IllegalAccessException {

		Random r = new Random(20);
		PiechartObserver<StockEvent> pieObserver = new PiechartObserver<StockEvent>();
		TableObserver<StockEvent> tableObserver = new TableObserver<StockEvent>();
		ThreeDObserver<StockEvent> threeDObserver = new ThreeDObserver<StockEvent>();
		StockQuoteObservable stock = new StockQuoteObservable();

		stock.addObserver(pieObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(threeDObserver);
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
