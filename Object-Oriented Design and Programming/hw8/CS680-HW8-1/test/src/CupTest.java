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

public class CupTest {

	@Test
	public void testSetPrice() {
		Cup c = new Cup();
		c.setPrice(1);
		assertThat(c.getPrice(), is(1.0));
	}

	@Test
	public void testSetSize() {
		Cup c = new Cup();
		c.setSize(Size.SMALL);
		assertThat(c.getSize(), is(Size.SMALL));
	}

	@Test
	public void testSetBottomScoop() {
		Scoop s = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Cup c = new Cup(1,Size.SMALL);
		c.setBottomScoop(s);
		assertThat(c.getBottomScoop(), is(s));
	}

}
