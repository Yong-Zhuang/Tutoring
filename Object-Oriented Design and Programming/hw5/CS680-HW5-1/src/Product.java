
public class Product {

	private String insurerName;
	private String productName;
	
	public Product (String insurerName,	String productName){

		this.insurerName=insurerName;
		this.productName=productName;

	}

	public String getInsurerName(){

		return this.insurerName;
	}
	
	public String getProductName(){

		return this.productName;
	}

}
