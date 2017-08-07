import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.salestax.model.Item;
import com.salestax.model.ItemOrigin;
import com.salestax.model.ItemType;
import com.salestax.model.Order;

public class SalesTaxAcceptenceTest {
	private Item product1;
	private Item product2;
	private Item product3;
	private Item product4;

	@Before
	public void setUp() throws Exception {
		setUpItems();
	}

	/*
	 * 1 imported bottle of perfume at 27.99, 1 bottle of perfume at 18.99
	 * 
	 * 1 packet of headache pills at 9.75 ,1 box of imported chocolates at 11.25
	 */
	private void setUpItems() {
		product1 = new Item("imported bottle of perfume", ItemType.COSMETICS,
				ItemOrigin.IMPORTED, new BigDecimal(27.99));
		product2 = new Item("bottle of perfume", ItemType.COSMETICS,
				ItemOrigin.LOCAL, new BigDecimal(18.99));
		product3 = new Item("packet of headache pills", ItemType.MEDICAL,
				ItemOrigin.LOCAL, new BigDecimal(9.75));
		product4 = new Item("box of imported chocolates", ItemType.FOOD,
				ItemOrigin.IMPORTED, new BigDecimal(11.25));
	}

	@Test
	public void Test_Case_Product1() {
		Order order = new Order();
		order.add(product1, 1);
		assertTrue(order.getSubTotal().compareTo(new BigDecimal("27.99")) == 0);
		assertTrue(order.getTaxTotal().compareTo(new BigDecimal("4.20")) == 0);
		assertTrue(order.getTotal().compareTo(new BigDecimal("32.19")) == 0);
		assertFalse(order.getTotal().compareTo(new BigDecimal("32.199")) == 0);
	}

	@Test
	public void Test_Case_Product2() {
		Order order = new Order();
		order.add(product2, 1);
		assertTrue(order.getSubTotal().compareTo(new BigDecimal("18.99")) == 0);
		assertTrue(order.getTaxTotal().compareTo(new BigDecimal("1.90")) == 0);
		assertTrue(order.getTotal().compareTo(new BigDecimal("20.89")) == 0);
	}

	@Test
	public void Test_Case_Product3() {
		Order order = new Order();
		order.add(product3, 1);
		assertTrue(order.getSubTotal().compareTo(new BigDecimal("9.75")) == 0);
		assertTrue(order.getTaxTotal().compareTo(new BigDecimal("0")) == 0);
		assertTrue(order.getTotal().compareTo(new BigDecimal("9.75")) == 0);
	}

	@Test
	public void Test_Case_Product4() {
		Order order = new Order();
		order.add(product4, 1);
		assertTrue(order.getSubTotal().compareTo(new BigDecimal("11.25")) == 0);
		assertTrue(order.getTaxTotal().compareTo(new BigDecimal("0.60")) == 0);
		assertTrue(order.getTotal().compareTo(new BigDecimal("11.85")) == 0);
	}

	@Test
	public void Test_Case_1() {
		Order order = new Order();
		order.add(product1, 1);
		order.add(product2, 1);
		order.add(product3, 1);
		order.add(product4, 1);
		assertTrue(order.getSubTotal().compareTo(new BigDecimal("67.98")) == 0);
		assertTrue(order.getTaxTotal().compareTo(new BigDecimal("6.70")) == 0);
		assertTrue(order.getTotal().compareTo(new BigDecimal("74.68")) == 0);
	}
}
