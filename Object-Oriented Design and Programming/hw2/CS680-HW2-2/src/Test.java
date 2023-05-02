import java.util.*;
import java.awt.Point;
public class Test {
	public static void main(String[] args) {
		ArrayList<Polygon> list = new ArrayList<Polygon>();
		Polygon tri1 = new Triangle(new Point(1, 2), new Point(1, 4), new Point(4, 2));
		Polygon tri2 = new Triangle(new Point(1, 2), new Point(1, 5), new Point(5, 0));
		Polygon rect1 = new Rectangle(new Point(0, 1), 10, 12);
		Polygon rect2 = new Rectangle(new Point(1, 2), 10, 5);

		list.add(tri1);
		list.add(tri2);
		list.add(rect1);
		list.add(rect2);

		Iterator<Polygon> iterator = list.iterator();
		while (iterator.hasNext()) {
			Polygon polygon = iterator.next();
			System.out.println(polygon.getClass().getName() + "Area: " + polygon.getArea());
		}
	}

}
