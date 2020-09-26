package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.ChangeStateException;
import exceptions.IdentificationException;

/**
 * CLIENT TEST
 * @author JuanP
 *
 */
class ClientTest {
	private Client client;
	private Product product;
	private Order order;
	private ArrayList<Product> products;
	
	public void setupStage1() throws IdentificationException {
		client = new Client(21212,32343,"PO","JUAN","GOMEZ","CIUDAD JARDIN");
	}
	
	public void setupStage2()throws ChangeStateException, IdentificationException{
	client = new Client(21212,32343,"CC","JUAN","GOMEZ","CIUDAD JARDIN");
	product = new Product(232432,23131,1232,"YUCA","Is a yuca");
	products = new ArrayList<Product>();
	products.add(product);
	order = new Order(232432,23131,products);
	client.orders.add(order);
	
	}
	
	@Test
	public void testIdentificationException() {
		try {
		setupStage1();
		}
		catch(IdentificationException ie) {
			assertTrue(true);
		}
	}
	@Test
	public void testSearchException() {
		try {
			setupStage2();
			client.changeState("DELIVERED", 0);
			client.changeState("REQUESTED", 0);
		} catch (IdentificationException e) {
			// TODO Auto-generated catch block
		} catch (ChangeStateException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		
	}

}
