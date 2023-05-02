package Observer;

public class StockQuoteObservable extends Observable {

	private StockEvent stockEvent;

	public void changeQuote(float quote, String ticker) {
		this.stockEvent = new StockEvent(quote, ticker);
		this.setChanged();
		this.notifyObservers(stockEvent);
	}

	public void changeQuote(StockEvent stockEvent) {
		this.stockEvent = stockEvent;
		this.setChanged();
		this.notifyObservers(stockEvent);
	}
}
