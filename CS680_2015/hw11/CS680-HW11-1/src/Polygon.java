package polygon;
import java.awt.Point;
import java.util.*;

public class Polygon {
	private ArrayList<Point> points;
	private AreaCalculator areaCalc;

	public Polygon(ArrayList<Point> points,AreaCalculator areaCalc) {
		this.points = points;
		this.areaCalc=areaCalc;
	}
	public void setAreaCalc(AreaCalculator areaCalc){
		this.areaCalc=areaCalc;
	}
	public void addPoint(Point point)
	{
		points.add(point);
	}
	public double getArea()
	{
		return this.areaCalc.getArea(this.points);
	}
}
