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
		Cone c = new Cone();
		c.setBottomScoop(s);
		assertThat(c.getBottomScoop(), is(s));
	}

}
