package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author JuanP
 * 
 *         Class Order
 * 
 */
public class Order implements Serializable, Comparable<Order> {
	public static final long serialVersionUID = 1;
	/** ATRIBUTES */
	int code;
	int clientCode;
	int restaurantNit;
	String date;
	List<Product> products;
	String state;

	/**
	 * Constructor of order class pre: pos: build a order instance
	 * 
	 * @param clientCode    the identification number of the client make the order
	 * @param restaurantNit the nit of the restaurant where buy the products
	 * @param products      the list of products
	 */
	public Order(int clientCode, int restaurantNit, List<Product> products) {

		code = (int) (Math.random() * 2500 + 1);
		this.clientCode = clientCode;
		this.restaurantNit = restaurantNit;
		this.products = products;
		state = "REQUESTED";
		date = new Date().toString();

	}

	/**
	 * Constructor of order class pre: pos: build a order instance
	 * 
	 * @param code          the code of the order
	 * @param clientCode    the identification number of the client make the order
	 * @param restaurantNit the nit of the restaurant where buy the products
	 * @param products      the list of products
	 */
	public Order(int code, int clientCode, int restaurantNit, List<Product> products) {

		this.code = code;
		this.clientCode = clientCode;
		this.restaurantNit = restaurantNit;
		this.products = products;
		state = "REQUESTED";
		date = new Date().toString();

	}

	/**
	 * set the code pre: pos: set the code
	 * 
	 * @param code the code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * get the code pre: pos: get the code
	 * 
	 * @return int code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set the client code pre: pos: set the client code
	 * 
	 * @param clientCode the client code
	 */
	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

	/**
	 * get the client code pre: pos:get the client code
	 * 
	 * @return int clientCode
	 */
	public int getClientCode() {
		return clientCode;
	}

	/**
	 * set the restaurant nit pre: pos: set the restaurant nit
	 * 
	 * @param restaurantNit the restaurant nit
	 */
	public void setRestaurantNit(int restaurantNit) {
		this.restaurantNit = restaurantNit;
	}

	/**
	 * get the restaurant nit pre: pos: get the restaurant nit
	 * 
	 * @return int restaurantNit
	 */
	public int getRestaurantNit() {
		return restaurantNit;
	}

	/**
	 * get the date pre: pos: get the date
	 * 
	 * @return Date date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * get the state pre: pos: get the state
	 * 
	 * @return State state
	 * 
	 */
	public String getState() {
		return state;
	}

	/**
	 * set the state pre: pos: set the state
	 * 
	 * @param state the state
	 */
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int compareTo(Order o) {
		int comp = date.compareTo(o.date);
		return comp;
	}

	/**
	 * get the products of the order pre: pos: get the products of the order
	 * 
	 * @return list of products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * set the products pre: pos: set the products
	 * 
	 * @param p the list of products
	 */
	public void setProducts(List<Product> p) {
		products = p;
	}

}
