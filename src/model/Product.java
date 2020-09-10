package model;

/**
 * @author JuanP
 * 
 * Class Product
 * 
 */
public class Product {
	
	/** ATRIBUTES */
	int code;
	int restaurantNit;
	int cost;
	String name;
	String description;
	
	
	/**
	 * Constructor of product class
	 * pre:
	 * pos: build a product instance
	 * @param code the code of the product
	 * @param restaurantNit the nit of the restauran with the product
	 * @param name the name of the product
	 * @param description the description of the product
	 * @param cost the cost of the product
	 */
	public Product(int code, int restaurantNit,int cost, String name,String description) {
		
		this.code = code;
		this.restaurantNit = restaurantNit;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	
	public void setCode(int code) {
		this.code =code;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setRestaurantNit(int restaurantNit) {
		this.restaurantNit = restaurantNit;
	}
	
	public int getRestaurantNit() {
		return restaurantNit;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
