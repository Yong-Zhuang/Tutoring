package polygon;
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.*;

public class TriangleAreaCalc implements AreaCalculator {
	public double getArea(ArrayList<Point> points) {
		double a = points.get(0).distance(points.get(1));
		double b = points.get(1).distance(points.get(2));
		double c = points.get(0).distance(points.get(2));
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		DecimalFormat df = new DecimalFormat("#.00");  
		return Double.parseDouble(df.format(area));
	}
}
