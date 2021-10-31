
import java.util.*;

public class ParetoComparator implements Comparator<Car>{
	
	public ParetoComparator(ArrayList<Car> cars) {
		// TODO Auto-generated constructor stub
		for(Car c: cars){
		 c.setCars(cars);
		}
	}

	public int compare(Car car1, Car car2){
		return car2.getDominationCount()-car1.getDominationCount();
	} 


}
