import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.awt.Point;
import java.util.ArrayList;
import polygon.*;

public class PolygonTest {
	@Test
	public void getAreaTest() {	
		ArrayList<Point> al = new  ArrayList<Point>();
		al.add(new Point(1, 2));
		al.add(new Point(1, 4));
		al.add(new Point(4, 2));
		Polygon p = new Polygon( al, new TriangleAreaCalc() );
		assertThat(p.getArea(), is(3.0));
		p.addPoint( new Point(4,4) );
		p.setAreaCalc( new RectangleAreaCalc() );
		assertThat(p.getArea(), is(6.0));
	}	
}
