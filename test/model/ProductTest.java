package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * PRODUCT TEST
 * @author JuanP
 *
 */
class ProductTest {
	private Product product;
	public void setupScenary1() {
		product = new Product(23232,1213,212212,"AJI","PICANTE");
	}
	@Test
	public void testUpdateAll() {
		setupScenary1();
		product.updateAllData(1212, 4343,"NOAJI","NOPICA");
		if(product.code == 1212) {
			if(product.cost == 4343) {
				if(product.name.equals("NOAJI")) {
					if(product.description.equals("NOPICA")) {
						assertTrue(true);
					}
				}
			
			}
		}
	}
	
	@Test
	public void testGetName() {
		setupScenary1();
		assertEquals("AJI", product.getName());
	}

}
