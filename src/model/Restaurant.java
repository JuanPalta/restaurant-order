package model;
/**
 * 
 * @author JuanP
 * 
 * Class Restaurant 
 *
 */
public class Restaurant {
	
	/** ATRIBUTES */
	int nit;
	String name;
	String nameAdmin;
	
	/**
	 * Constructor of restaurant class
	 * pre:
	 * pos: build a restaurant instance
	 * @param nit the n.i.t of the restaurant
	 * @param name the name of the restaurant
	 * @param nameAdmin the name of the administrator of the restaurant
	 */
	public Restaurant(int nit,String name, String nameAdmin) {
		
		this.nit = nit;
		this.name=name;
		this.nameAdmin = nameAdmin;
	}
	
	public void setNit(int nit) {
		
		this.nit = nit;
	}
	
	public int getNit() {
		return nit;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}
	
	public String getNameAdmin() {
		return nameAdmin;
	}
	
}
