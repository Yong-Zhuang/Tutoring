
public class TableObserver implements Observer {

	private StockEvent arg;

	public void update(Observable observer, Object arg) {

		this.arg = (StockEvent) arg;
		draw();
	}

	private void draw() {
		System.out.println("Table monitor: Ticker: " + arg.getTicker() + " Quote: " + arg.getQuote());
	}
}
