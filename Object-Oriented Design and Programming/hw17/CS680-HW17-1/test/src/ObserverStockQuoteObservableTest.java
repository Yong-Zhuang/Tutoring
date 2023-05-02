
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.Before;
import Observer.*;


public class ObserverStockQuoteObservableTest {

	private StockQuoteObservable stock;
	private float quote;
	@Before
	public void init(){
		PiechartObserver pieObserver = new PiechartObserver();
		TableObserver tableObserver = new TableObserver();
		ThreeDObserver threeDObserver = new ThreeDObserver();
		stock = new StockQuoteObservable();

		stock.addObserver(pieObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(threeDObserver);
		quote = 21.6f;
	}
	@Test
	public void testChangeQuoteFloatString() throws InterruptedException{
		stock.changeQuote(quote, "Microsoft Stock");
	}

	@Test
	public void testChangeQuoteStockEvent() throws InterruptedException{
		stock.changeQuote(new StockEvent(quote, "Microsoft Stock"));
	}

}
