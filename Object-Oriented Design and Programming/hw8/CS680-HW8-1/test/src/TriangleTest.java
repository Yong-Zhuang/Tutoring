import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.awt.Point;
import java.util.ArrayList;
import polygon.Polygon;
import polygon.Triangle;

public class TriangleTest {
	@Test
	public void getAreaTest() {	
		Polygon tri1 = new Triangle(new Point(1, 2), new Point(1, 4), new Point(4, 2));
		double expected=3;
		assertThat(tri1.getArea(), is(expected));
	}	
	@Test
	public void getPointsTest() {	
		Polygon tri1 = new Triangle(1, 2, 1, 4, 4, 2);
		ArrayList<Point> expected=new ArrayList<Point>();
		expected.add(new Point(1, 2));
		expected.add(new Point(1, 4));
		expected.add(new Point(4, 2));
		assertThat(tri1.getPoints(), is(expected));
	}	
}
