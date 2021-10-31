package icecream;
import java.util.*;

public class Container {

	private double price;
	private Size size;
	private Scoop bottomScoop;

	public Container () {
	}
	public Container (double price,Size size) {
		this.price = price;
		this.size = size;
	}
	public void setPrice(double price) {
	
		this.price = price;
	}

	public void setSize(Size size) {
		
		this.size = size;
	}

	public void setBottomScoop(Scoop scoop) {
		scoop.setLayerNum(1);
		this.bottomScoop=scoop;
	}
	public double getPrice() {
		
		return price;
	}

	public Size getSize() {
		
		return size;
	}

	public Scoop getBottomScoop() {
	
		return bottomScoop;
	}

	public String toString () {

		StringBuffer buffer = new StringBuffer();
		buffer.append("Container: ");
		buffer.append(this.getClass().getName() + "\r\n");
		if (this instanceof Cone) {
			buffer.append("Topping: " + ((Cone)this).getTopping() + "\r\n");
		}

		double price=this.price;
		buffer.append("Size: " + size +"  Price: "+price+ "\r\n");

		Scoop scoop = bottomScoop;

		while (scoop !=  null) {
			price+=scoop.getPrice();
			buffer.append("Scoop: " + scoop.getLayerNum() + "\r\n");
			buffer.append("Toppings: ");
			for (Topping topping : scoop.getToppings()) {
				buffer.append(topping + ", ");
			}
			buffer.append("\r\n");	
			buffer.append("Flavor: " + scoop.getFlavor()+"  Price: "+scoop.getPrice() + "\r\n");
			scoop = scoop.getUp();
		}			
			
		buffer.append("\r\n");		
		buffer.append("Total Price: " + price + "\r\n");
		return buffer.toString();
	}	 			
}
