package model;

import java.io.Serializable;

/**
 * @author JuanP
 * 
 *         Class Product
 * 
 */
public class Product implements Serializable, Comparable<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ATRIBUTES */
	int code;
	int restaurantNit;
	int cost;
	String name;
	String description;

	/**
	 * Constructor of product class pre: pos: build a product instance
	 * 
	 * @param code          the code of the product
	 * @param restaurantNit the nit of the restauran with the product
	 * @param name          the name of the product
	 * @param description   the description of the product
	 * @param cost          the cost of the product
	 */
	public Product(int code, int restaurantNit, int cost, String name, String description) {

		this.code = code;
		this.restaurantNit = restaurantNit;
		this.name = name;
		this.description = description;
		this.cost = cost;
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
	 * set restaurant Nit pre: pos: set the restaurant nit
	 * 
	 * @param restaurantNit the restaurant nit
	 */
	public void setRestaurantNit(int restaurantNit) {
		this.restaurantNit = restaurantNit;
	}

	/**
	 * get restaurant nit pre: pos: get the restaurant nit
	 * 
	 * @return int restaurantNit
	 */
	public int getRestaurantNit() {
		return restaurantNit;
	}

	/**
	 * set the cost pre: pos: set the cost
	 * 
	 * @param cost the cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * get the cost pre: pos: get the cost
	 * 
	 * @return int cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * set the name pre: pos: set the name
	 * 
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the name pre: pos: get the name
	 * 
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the description pre: pos: set the description
	 * 
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the description pre: pos: get the description
	 * 
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * update All data pre: pos: update all data of the product
	 * 
	 * @param code        the code
	 * @param cost        the cost
	 * @param name        the name
	 * @param description the description
	 */
	public void updateAllData(int code, int cost, String name, String description) {
		setCode(code);
		setCost(cost);
		setName(name);
		setDescription(description);
	}

	@Override
	public int compareTo(Product p) {
		int comp;
		if (code < p.code) {
			comp = -1;
		} else if (code > p.code) {
			comp = 1;
		} else {
			comp = 0;
		}
		return comp;
	}
}
