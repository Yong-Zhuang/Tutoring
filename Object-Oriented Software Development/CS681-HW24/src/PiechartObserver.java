
public class PiechartObserver implements Observer {

	private StockEvent arg;

	public void update(Observable observer, Object arg) {

		this.arg = (StockEvent) arg;
		draw();
	}

	private void draw() {
		System.out.println("Piechart monitor: Ticker: " + arg.getTicker() + " Quote: " + arg.getQuote());
	}
}
