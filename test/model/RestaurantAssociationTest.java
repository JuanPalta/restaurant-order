package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import exceptions.SearchException;
/**
 * RESTAURANT ASSOCIATION TEST
 * @author JuanP
 *
 */
class RestaurantAssociationTest {
	Restaurant restaurant;
	RestaurantAssociation restaurantA;
	public void setupScenary1() {
		try {
			restaurantA = new RestaurantAssociation();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		restaurant = new Restaurant(23131,"CARREFOUR","JUAN");
		restaurantA.getRestaurants().add(restaurant);
	}
	@Test
	public void testSearchRestaurant() {
		setupScenary1();
		try {
			if(restaurantA.searchRestaurant(23131) != null ) {
				assertTrue(true);
			}
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRegisterRestaurant() {
		setupScenary1();
		try {
			restaurantA.registerRestaurant(12123,"EXITO","ANGIE");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(restaurantA.getRestaurants().size() == 2) {
			assertTrue(true);
		}
		
	}

}
