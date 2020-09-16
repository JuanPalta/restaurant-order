package model;
import java.io.Serializable;

/**
 * @author JuanP
 * 
 * Class Product
 * 
 */
public class Product implements Serializable {
	
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
	
	/**
	 * pre:
	 * pos:
	 * @param code
	 */
	public void setCode(int code) {
		this.code =code;
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
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int cost
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}
	
	public void updateAllData(int code,int cost,String name,String description){
		setCode(code);
		setCost(cost);
		setName(name);
		setDescription(description);
	}
}
