package model;

import java.util.Date;
import java.util.List;


/**
 * @author JuanP
 * 
 * Class Order
 * 
 */
public class Order {
	
	/** ATRIBUTES */
	int code;
	int clientCode;
	int restaurantNit;
	Date date;
	List<Product> products;
	
	/**
	 * Constructor of order class
	 * pre:
	 * pos: build a order instance
	 * @param code the code of the order
	 * @param clientCode the identification number of the client make the order
	 * @param restaurantNit the nit of the restaurant where buy the products
	 * @param products the list of products
	 */
	public Order(int code, int clientCode,int restaurantNit, List<Product> products) {
		
		this.code = code;
		this.clientCode = clientCode;
		this.restaurantNit = restaurantNit;
		this.products = products;
		
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}
	
	public int getClientCode() {
		return clientCode;
	}
	
	public void setRestaurantNit(int restaurantNit) {
		this.restaurantNit = restaurantNit;
	}
	
	public int getRestaurantNit() {
		return restaurantNit;
	}
	
	public Date getDate() {
		return date;
	}
	
	public List<Product> getProducts(){
		return products;
	}
}
