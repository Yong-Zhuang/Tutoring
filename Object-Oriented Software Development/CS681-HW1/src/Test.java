import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = new ArrayList<Car>();//String name, int year,  float mileage, int price
		cars.add(new Car("Audi(A)",2008,4100f,5000));
		cars.add(new Car("Jaguar(B)",2009,5100f,8100));
		cars.add(new Car("Mini(C)",2010,7100f,12000));
		cars.add(new Car("Mazda(D)",2011,3100f,8200));
		cars.add(new Car("BMW(E)",2012,2100f,8300));
		System.out.println("Name | Year |  Mileage | Price");
		cars.forEach((Car c)->System.out.println(c+" | "+c.getYear()+" |  "+c.getMileage()+" | "+c.getPrice()));
		System.out.println("------Sorting results------");
		Collections.sort(cars, Comparator.comparing((Car car)->car.getYear()));
		System.out.println("YearComparator: "+cars);
		Collections.sort(cars,  Comparator.comparing((Car car)->car.getMileage()));
		System.out.println("MileageComparator: "+cars);
		Collections.sort(cars,  Comparator.comparing((Car car)->car.getPrice()));
		System.out.println("PriceComparator: "+cars);	
	}

}
