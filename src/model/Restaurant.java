package model;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author JuanP
 * 
 * Class Restaurant 
 *
 */
public class Restaurant implements Serializable{
	public static final long serialVersionUID = 1;
	/** ATRIBUTES */
	int nit;
	String name;
	String nameAdmin;
	List<Product> products;
	List<Client> clients;
	
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
		products = new ArrayList<Product>();
		clients = new ArrayList<Client>();
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
	
	/**
	 * pre:
	 * pos:
	 * @return List<Product> products
	 */
	public List<Product> getProducts(){
		return products;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return List<Client> products
	 */
	public List<Client> getClients(){
		return clients;
	}
	
	/**
	 * 
	 * @param product
	 */
	public void addProduct() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT CODE: ");
		int code = Integer.parseInt(sc.nextLine());
		System.out.println("INSERT COST: ");
		int cost = Integer.parseInt(sc.nextLine());
		System.out.println("INSERT THE NAME: ");
		String name = sc.nextLine();
		System.out.println("INSERT THE DESCRIPTION: ");
		String description = sc.nextLine();
		int count = 0;
		for(int i=0;i<products.size();i++) {
			
			if(products.get(i).code == code) {
				count++;
			}
			
		}
		if(count == 0) {
			products.add(new Product(code,nit,cost,name,description));
		} else {
			
			System.out.println("could not be added because there is already a product with that code");
		}
		
		
	}
	
	public void addClient() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT IDENTIFICATION NUMBER: ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("INSERT THE PHONE: ");
		int p = Integer.parseInt(sc.nextLine());
		System.out.println("INSERT IDENTIFICATION TYPE : TI/PP/CC/CE");
		String t = sc.nextLine();
		System.out.println("INSERT THE FIRSTNAME: ");
		String f = sc.nextLine();
		System.out.println("INSERT THE LASTNAME: ");
		String l = sc.nextLine();
		System.out.println("INSERT ADDRES");
		String a = sc.nextLine();
		clients.add(new Client(n,p,t,f,l,a));
		System.out.println("Client was registered correctly ");
	}
	
}
