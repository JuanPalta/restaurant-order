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
	
	/**
	 * pre:
	 * pos:
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param clientCode
	 */
	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int clientCode
	 */
	public int getClientCode() {
		return clientCode;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param restaurantNit
	 */
	public void setRestaurantNit(int restaurantNit) {
		this.restaurantNit = restaurantNit;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int restaurantNit
	 */
	public int getRestaurantNit() {
		return restaurantNit;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return Date date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return List<Product> products
	 */
	public List<Product> getProducts(){
		return products;
	}
}
