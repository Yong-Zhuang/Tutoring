
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;

import Multicast.*;

public class MulticastStockQuoteObservableTest {
	public StockQuoteObservable stock;
	public float quote;
	@Before
	public void init(){
		PiechartObserver<StockEvent> pieObserver = new PiechartObserver<StockEvent>();
		TableObserver<StockEvent> tableObserver = new TableObserver<StockEvent>();
		ThreeDObserver<StockEvent> threeDObserver = new ThreeDObserver<StockEvent>();
		stock = new StockQuoteObservable();

		stock.addObserver(pieObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(threeDObserver);
		quote = 21.6f;
	}
	@Test
	public void testChangeQuoteFloatString() throws InterruptedException, IllegalArgumentException, IllegalAccessException{

			stock.changeQuote(quote, "Microsoft Stock");
	
	}

	@Test
	public void testChangeQuoteStockEvent() throws InterruptedException, IllegalArgumentException, IllegalAccessException{
		stock.changeQuote(new StockEvent(quote, "Microsoft Stock"));
	}
}
