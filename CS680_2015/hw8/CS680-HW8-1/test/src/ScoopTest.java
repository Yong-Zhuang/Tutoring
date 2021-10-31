import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import icecream.Flavor;
import icecream.Scoop;
import icecream.Topping;

public class ScoopTest {

	@Test
	public void testSetFlavor() {
		Scoop s = new Scoop ();
		s.setFlavor(Flavor.CHOCOLATE);
		assertThat(s.getFlavor(), is(Flavor.CHOCOLATE));
	}

	@Test
	public void testSetToppings() {
		Scoop s = new Scoop ();
		List<Topping> list=Arrays.asList(Topping.NUTS,Topping.STRAWBERRYJEERRY);
		s.setToppings(list);
		assertThat(s.getToppings(), is(list));
	}

	@Test
	public void testSetPrice() {
		Scoop s = new Scoop ();
		s.setPrice(4.5);
		assertThat(s.getPrice(), is(4.5));
	}

	@Test
	public void testSetDown() {
		Scoop scoop1 = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Scoop s = new Scoop ();
		s.setDown(scoop1);
		assertThat(s.getDown(), is(scoop1));
	}

	@Test
	public void testSetLayerNum() {
		Scoop s = new Scoop ();
		s.setLayerNum(2);
		assertThat(s.getLayerNum(), is(2));
	}

	@Test
	public void testAddScoop() {
		Scoop scoop1 = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Scoop s = new Scoop ();
		s.setLayerNum(2);
		s.addScoop(scoop1);
		assertThat(s.getUp(), is(scoop1));
		assertThat(scoop1.getLayerNum(), is(3));
	}
	@Test
	public void testAddScoopWithMAX_SCOOP_NUM() {
		Scoop scoop1 = new Scoop (Flavor.VANILLA, 3.0, Arrays.asList(Topping.NUTS));
		Scoop s = new Scoop ();
		s.setLayerNum(3);
		s.addScoop(scoop1);
		assertThat(s.getUp(), is(nullValue()));
		assertThat(scoop1.getDown(), is(nullValue()));
	}

}
