import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.awt.Point;
import java.util.ArrayList;
import polygon.Polygon;
import polygon.Rectangle;

public class RectangleTest {
	@Test
	public void getAreaTest() {	
		Polygon rect1 = new Rectangle(0, 1, 10, 12);
		double expected=120;
		assertThat(rect1.getArea(), is(expected));
	}	
	@Test
	public void getPointsTest() {	
		Polygon rect1 = new Rectangle(new Point(0, 1), 10, 12);
		ArrayList<Point> expected=new ArrayList<Point>();
		expected.add(new Point(0, 1));
		expected.add(new Point(10, 1));
		expected.add(new Point(0, -11));
		expected.add(new Point(10, -11));
		assertThat(rect1.getPoints(), is(expected));
	}	
}
