
import java.util.*;

public class Car {
	private int price;
	private int year;
	private String name;
	private float mileage;
	private ArrayList<Car> cars;

	public Car(String name, int year,  float mileage, int price){

		this.name = name;
		this.year = year;
		this.mileage = mileage;
		this.price = price;	

	}
	public int getYear(){

		return this.year;

	}

	public float getMileage(){

		return this.mileage;

	}

	public int getPrice(){

		return this.price;

	}	
	public String toString()
	{
		return this.name;
	}
	public void setCars(ArrayList<Car> cars)
	{
		this.cars=cars;
	}
	public int getDominationCount(){
		int count=0;
		for(Car c: this.cars){
			if(this.price==c.getPrice()&&this.year==c.getYear()&&this.mileage==c.getMileage())
			{
				continue;
			}
			if(this.price>=c.getPrice()&&this.year<=c.getYear()&&this.mileage>=c.getMileage())
			{
				count++;
			}
		}
		return count;
	}
}
