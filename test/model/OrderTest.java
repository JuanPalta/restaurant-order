package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * ORDER TEST
 * @author JuanP
 *
 */
class OrderTest {
	
	private Order order;
	private Product product;
	private ArrayList<Product> products;
	public void setupScenary1() {
		product = new Product(232432,23131,1232,"YUCA","Is a yuca");
		products = new ArrayList<Product>();
		products.add(product);
		order = new Order(2121324,232432,23131,products);
	}
	@Test
	public void testConstructor() {
		setupScenary1();
		if(order.state.equalsIgnoreCase("REQUESTED")) {
			assertTrue(true);
		}
		else {
			fail();
		}
		
	}
	
	@Test
	public void testSetState() {
		setupScenary1();
		order.setState("IN PROCCESS");
		if(order.getState().equalsIgnoreCase("IN PROCCESS")) {
			assertTrue(true);
		}
	}

}
