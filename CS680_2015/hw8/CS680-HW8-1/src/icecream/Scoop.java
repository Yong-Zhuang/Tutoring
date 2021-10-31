package icecream;
import java.util.*;

public class Scoop {

	private static final int MAX_SCOOP_NUM=3;
	private Flavor flavor;
	private List<Topping> toppings;
	private double price;
	private Scoop up;
	private Scoop down;
	private int layerNum;

	public Scoop()
	{}
	public Scoop (Flavor flavor, double price,List<Topping> toppings) {
		this.flavor = flavor;
		this.toppings = toppings;
		this.price = price;
	}

	public void setFlavor(Flavor flavor) {

		this.flavor = flavor;
	}

	public void setToppings (List<Topping> toppings) {

		this.toppings = toppings;
  	}

	public void setPrice (double price) {

		this.price = price;
	}	

	public void setDown(Scoop down) {
		this.down = down;
	}

	public Flavor getFlavor() {

		return flavor;
	}

	public List<Topping> getToppings() {
		
		return toppings;
	}

	public double getPrice() {
		
		return price;
	}

	public Scoop getUp() {
		
		return up;
	}

	public Scoop getDown() {
		
		return down;
	}
	public int getLayerNum(){	
		return this.layerNum;
	}
	public void setLayerNum(int layerNum)
	{
		this.layerNum=layerNum;
	}
	public void addScoop(Scoop scoop){
		if(getLayerNum()>=MAX_SCOOP_NUM){
			System.out.println("This ice-cream is too big to add any scoop. ");
			return;
		}
		scoop.setDown(this);
		scoop.setLayerNum(this.layerNum+1);
		this.up= scoop;
	}
}

