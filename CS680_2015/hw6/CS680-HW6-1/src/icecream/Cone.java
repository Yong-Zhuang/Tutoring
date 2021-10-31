package icecream;
public class Cone extends Container{

	private Topping topping;
	public Cone(){}
	public Cone (double price,Size size) {
		super(price,size);
	}
	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}
		
}
