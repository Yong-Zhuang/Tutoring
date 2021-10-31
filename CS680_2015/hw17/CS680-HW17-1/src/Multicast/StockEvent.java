package Multicast;

public class StockEvent{

	public String ticker;
	public float quote;

	public StockEvent( float quote, String ticker){

		this.ticker=ticker;
		this.quote=quote;
		
	}

}
