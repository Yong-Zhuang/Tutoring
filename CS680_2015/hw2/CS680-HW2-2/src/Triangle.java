
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.*;

public class Triangle implements Polygon {
	private ArrayList<Point> points;
	private double area;

	public Triangle(Point p1, Point p2, Point p3) {
		points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
	}

	public Triangle(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y) {
		points = new ArrayList<Point>();
		points.add(new Point(p1x, p1y));
		points.add(new Point(p2x, p2y));
		points.add(new Point(p3x, p3y));
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public double getArea() {
		double a = points.get(0).distance(points.get(1));
		double b = points.get(1).distance(points.get(2));
		double c = points.get(0).distance(points.get(2));
		double s = (a + b + c) / 2;
		this.area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		DecimalFormat df = new DecimalFormat("#.00");  
		this.area=Double.parseDouble(df.format(this.area));  
		return this.area;
	}
}
