package polygon;
import java.awt.Point;
import java.util.*;

public class Rectangle implements Polygon {

	private Point upperLeft;
	private int width;
	private int height;
	private ArrayList<Point> points;
	private double area;

	// Constructs a new Rectangle whose upper-left corner is the specified
	// Point,
	// and whose width and height are specified by the arguments of the same
	// name.
	public Rectangle(Point upperLeft, int width, int height) {
		points = new ArrayList<Point>();
		this.upperLeft = upperLeft;
		this.height = height;
		this.width = width;
	}

	// Constructs a new Rectangle whose upper-left corner is specified as (x,y)
	// and whose width and height are specified by the arguments of the same
	// name.
	public Rectangle(int x, int y, int width, int height) {
		points = new ArrayList<Point>();
		this.upperLeft = new Point(x, y);
		this.height = height;
		this.width = width;
	}

	public ArrayList<Point> getPoints() {
		Point upperRight = new Point(upperLeft.x + width, upperLeft.y);
		Point botLeft = new Point(upperLeft.x, upperLeft.y - height);
		Point botRight = new Point(upperLeft.x + width, upperLeft.y - height);
		points.add(upperLeft);
		points.add(upperRight);
		points.add(botLeft);
		points.add(botRight);
		return points;
	}

	public double getArea() {
		this.area = height * width;
		return this.area;
	}
}
