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
}
