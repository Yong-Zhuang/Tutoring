
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.*;

public class Polygon {
	private ArrayList<Point> points;
	private AreaCalculator areaCalc;


	public Polygon(ArrayList<Point> points) {
		if (points.size() == 3) {
			Polygon(points, (Polygon p) -> {
				double a = points.get(0).distance(points.get(1));
				double b = points.get(1).distance(points.get(2));
				double c = points.get(0).distance(points.get(2));
				double s = (a + b + c) / 2;
				double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
				DecimalFormat df = new DecimalFormat("#.00");
				return Double.parseDouble(df.format(area));
			});
		} else {
			Polygon(points, null);
		}
	}

	public void Polygon(ArrayList<Point> points, AreaCalculator areaCalc) {
		this.points = points;
		this.areaCalc = areaCalc;
	}
	public ArrayList<Point> getPoints() {
		return this.points;
	}

	public void setAreaCalc(AreaCalculator areaCalc) {
		this.areaCalc = areaCalc;
	}

	public void addPoint(Point point) {
		points.add(point);
	}

	public double getArea() {
		return this.areaCalc.getArea(this);
	}
}
