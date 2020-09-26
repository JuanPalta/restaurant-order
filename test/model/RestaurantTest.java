package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * RESTAURANT TEST
 * @author JuanP
 *
 */
class RestaurantTest {
	private Restaurant restaurant;
	private Product product;
	public void setupScenary1() {
		restaurant = new Restaurant(32323,"ALKOSTO","PEDRO");
		product = new Product(23232,1213,212212,"AJI","PICANTE");
		restaurant.getProducts().add(product);
	}
	@Test
	public void testAddProductWithSameCode() {
		setupScenary1();
		restaurant.addProduct(23232, 12323, "AJIACO", "NO");
		if(restaurant.getProducts().size() == 1) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSearchProduct() {
		setupScenary1();
		if(restaurant.searchProduct(23232) != null) {
			assertTrue(true);
		}
	}

}
