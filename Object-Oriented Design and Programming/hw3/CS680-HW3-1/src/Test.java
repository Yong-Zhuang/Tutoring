import java.util.*;
public class Test {

	public static Container createCup() {
		
		Cup cup = new Cup (1,Size.LARGE);
		Scoop scoop1 = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Scoop scoop2 = new Scoop (Flavor.CHOCOLATE, 2.0, Arrays.asList(Topping.EXTRACHOCOLATE));
		Scoop scoop3 = new Scoop (Flavor.CHOCOLATE, 1.0, Arrays.asList(Topping.NUTS,Topping.STRAWBERRYJEERRY));

		cup.setBottomScoop(scoop1);
        scoop1.addScoop(scoop2);
        scoop2.addScoop(scoop3);
		
		return cup;
        }

			
    
	public static Container createCone() {

		Cone cone = new Cone(2,Size.LARGE);
		cone.setTopping(Topping.NUTS);

		Scoop scoop1 = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Scoop scoop2 = new Scoop (Flavor.CHOCOLATE, 2.0, Arrays.asList(Topping.EXTRACHOCOLATE));
		Scoop scoop3 = new Scoop (Flavor.CHOCOLATE, 1.0, Arrays.asList(Topping.NUTS,Topping.STRAWBERRYJEERRY));
		
		cone.setBottomScoop(scoop1);
        scoop1.addScoop(scoop2);
        scoop2.addScoop(scoop3);

		return cone;
	}

	public static void main(String[] args) {
		Container cone1 = createCone();
		System.out.println(cone1);
		Container cup1 = createCup();
		System.out.println(cup1);		
	}
}
