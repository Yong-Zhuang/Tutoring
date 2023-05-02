
public class StockEvent{

	private String ticker;
	private float quote;

	public StockEvent( float quote, String ticker){

		this.ticker=ticker;
		this.quote=quote;
		
	}
	public String getTicker(){
		return this.ticker;
	}

	public float getQuote(){
		return this.quote;
	}

}
