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
	
	/**
	 * pre:
	 * pos: change the nit
	 * @param nit
	 */
	public void setNit(int nit) {
		
		this.nit = nit;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int nit
	 */
	public int getNit() {
		return nit;
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
	 * @param nameAdmin
	 */
	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return String nameAdmin
	 */
	public String getNameAdmin() {
		return nameAdmin;
	}
	
}
