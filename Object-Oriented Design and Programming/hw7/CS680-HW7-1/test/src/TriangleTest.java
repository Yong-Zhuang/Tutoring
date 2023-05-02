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
}
