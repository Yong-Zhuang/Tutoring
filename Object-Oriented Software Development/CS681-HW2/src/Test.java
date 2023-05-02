import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
public class Test {

	public static void main(String[] args) {
		ArrayList<Point> al = new  ArrayList<Point>();
		al.add(new Point(1, 2));
		al.add(new Point(1, 4));
		al.add(new Point(4, 2));
		Polygon p = new Polygon( al,(ArrayList<Point> points)->{
			double a = points.get(0).distance(points.get(1));
			double b = points.get(1).distance(points.get(2));
			double c = points.get(0).distance(points.get(2));
			double s = (a + b + c) / 2;
			double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			DecimalFormat df = new DecimalFormat("#.00");  
			System.out.println("the three points can not construct a triangle!");
			return Double.parseDouble(df.format(area));
		});
		System.out.println("Triangle: point (1, 2), point (1, 4), point (4, 2)");
		System.out.println("Area: "+ p.getArea());
		
		p.addPoint( new Point(4,4) );
		p.setAreaCalc( (ArrayList<Point> points)->{
					float l1,l2, l3;
		System.out.println("Calling RectangleAreaCalc");
			 Point a;
	 Point b;
	 Point c;
	 Point d;
	double area=0;

		a = points.get(0); 
		b = points.get(1);
		c = points.get(2);
		d = points.get(3);
		l1 = (float) Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		l2 = (float) Math.sqrt((a.x-c.x)*(a.x-c.x)+(a.y-c.y)*(a.y-c.y));
		l3 = (float) Math.sqrt((a.x-d.x)*(a.x-d.x)+(a.y-d.y)*(a.y-d.y));
		float fArr[] = {l1,l2,l3};
		Arrays.sort(fArr);
		l1 = fArr[0];
		l2 = fArr[1];
		l3 = fArr[2];
		if (l1*l1 + l2*l2 == l3*l3)
			area = l1*l2;
		else
			System.out.println("the four points can not construct a rectangle!");
		
		return area;
		} );
		System.out.println("Rectangle: point (1, 2), point (1, 4), point (4, 2), point (4, 4)");
		System.out.println("Area: "+ p.getArea());
	}

}
