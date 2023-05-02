import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = new ArrayList<Car>();//String name, int year,  float mileage, int price
		cars.add(new Car("Audi(A)",2008,4100f,5000));
		cars.add(new Car("Jaguar(B)",2009,5100f,8000));
		cars.add(new Car("Mini(C)",2010,7100f,12000));
		cars.add(new Car("Mazda(D)",2011,3100f,8000));
		cars.add(new Car("BMW(E)",2012,2100f,8000));
		System.out.println("Name | Year |  Mileage | Price");
		for(Car c: cars){
			System.out.println(c+" | "+c.getYear()+" |  "+c.getMileage()+" | "+c.getPrice());
		}
		System.out.println("------Sorting results------");
		Collections.sort(cars, new YearComparator());
		System.out.println("YearComparator: "+cars);
		Collections.sort(cars, new MileageComparator());
		System.out.println("MileageComparator: "+cars);
		Collections.sort(cars, new PriceComparator());
		System.out.println("PriceComparator: "+cars);
		Collections.sort(cars, new ParetoComparator(cars));
		System.out.println("ParetoComparator: "+cars);
		
	}

}
