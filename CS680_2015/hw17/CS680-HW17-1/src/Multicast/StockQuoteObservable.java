package Multicast;

public class StockQuoteObservable extends Observable<StockEvent> {

	private StockEvent stockEvent;

	public void changeQuote(float quote, String ticker) throws IllegalArgumentException, IllegalAccessException {
		this.stockEvent = new StockEvent(quote, ticker);
		this.setChanged();
		this.notifyObservers(this.stockEvent);
	}

	public void changeQuote(StockEvent stockEvent) throws IllegalArgumentException, IllegalAccessException {
		this.stockEvent = stockEvent;
		this.setChanged();
		this.notifyObservers(stockEvent);
	}
}
