package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author JuanP
 * 
 * Class Order
 * 
 */
public class Order implements Serializable {
	public static final long serialVersionUID = 1;
	/** ATRIBUTES */
	int code;
	int clientCode;
	int restaurantNit;
	String date;
	List<Product> products;
	String state;
	
	/**
	 * Constructor of order class
	 * pre:
	 * pos: build a order instance
	 * @param code the code of the order
	 * @param clientCode the identification number of the client make the order
	 * @param restaurantNit the nit of the restaurant where buy the products
	 * @param products the list of products
	 */
	public Order(int clientCode,int restaurantNit, List<Product> products) {
		
		code = (int) Math.random();
		this.clientCode = clientCode;
		this.restaurantNit = restaurantNit;
		this.products = products;
		state = "REQUESTED";
		date = new Date().toString();
		
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
	public String getDate() {
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
