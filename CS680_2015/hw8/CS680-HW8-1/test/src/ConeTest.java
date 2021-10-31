import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.Arrays;

import org.junit.Test;

import icecream.*;
import icecream.Flavor;
import icecream.Scoop;
import icecream.Size;
import icecream.Topping;

public class ConeTest {

	@Test
	public void testSetTopping() {
		Cone c = new Cone();
		c.setTopping(Topping.NUTS);
		assertThat(c.getTopping(), is(Topping.NUTS));
	}

	@Test
	public void testSetPrice() {
		Cone c = new Cone();
		c.setPrice(1);
		assertThat(c.getPrice(), is(1.0));
	}

	@Test
	public void testSetSize() {
		Cone c = new Cone();
		c.setSize(Size.SMALL);
		assertThat(c.getSize(), is(Size.SMALL));
	}

	@Test
	public void testSetBottomScoop() {
		Scoop s = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Container c = new Cone(1,Size.SMALL);
		c.setBottomScoop(s);
		assertThat(c.getBottomScoop(), is(s));		
	}
	@Test
	public void testTopping() {	
		Size [] ss = Size.values();
		Size s = Size.valueOf("SMALL");
		Flavor [] fs = Flavor.values();
		Flavor f = Flavor.valueOf("VANILLA");
		Topping [] ts = Topping.values();
		Topping t = Topping.valueOf("NUTS");	
		
	}

}
