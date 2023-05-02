package polygon;
import java.awt.Point;
import java.util.*;

public class RectangleAreaCalc implements AreaCalculator {
	public double getArea(ArrayList<Point> points) {
		double a = points.get(0).distance(points.get(1));
		double b = points.get(0).distance(points.get(2));
		double c = points.get(0).distance(points.get(3));
		double d = points.get(1).distance(points.get(2));
		double e = points.get(1).distance(points.get(3));
		double f = points.get(2).distance(points.get(3));
	    if(a==f &&b==e &&c==d){
	    	double[] sides = new double[] { a,b,c,d,e,f }; 
	    	Arrays.sort(sides);
	    	return sides[0]*sides[2];
	    }
	    return 0;
	}
}
