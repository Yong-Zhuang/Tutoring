import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
public class Test {

	public static void main(String[] args) {
		ArrayList<Point> al = new  ArrayList<Point>();
		al.add(new Point(1, 2));
		al.add(new Point(1, 4));
		al.add(new Point(4, 2));
		Polygon p = new Polygon( al);
		System.out.println("Triangle: point (1, 2), point (1, 4), point (4, 2)");
		System.out.println("Area: "+ p.getArea());
		
		p.addPoint( new Point(4,4) );
		p.setAreaCalc( (Polygon p1)->{
			double a = p1.getPoints().get(0).distance(p1.getPoints().get(1));
			double b = p1.getPoints().get(0).distance(p1.getPoints().get(2));
			double c = p1.getPoints().get(0).distance(p1.getPoints().get(3));
			double d = p1.getPoints().get(1).distance(p1.getPoints().get(2));
			double e = p1.getPoints().get(1).distance(p1.getPoints().get(3));
			double f = p1.getPoints().get(2).distance(p1.getPoints().get(3));
		    if(a==f &&b==e &&c==d){
		    	double[] sides = new double[] { a,b,c,d,e,f }; 
		    	Arrays.sort(sides);
		    	return sides[0]*sides[2];
		    }
		    return 0;	
		} );
		System.out.println("Rectangle: point (1, 2), point (1, 4), point (4, 2), point (4, 4)");
		System.out.println("Area: "+ p.getArea());
	}

}
