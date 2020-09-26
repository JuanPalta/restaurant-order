package model;

import java.util.List;

import exceptions.IdentificationException;
import exceptions.SearchException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

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
	 * set the nit
	 * pre:
	 * pos: change the nit
	 * @param nit the nit
	 */
	public void setNit(int nit) {
		
		this.nit = nit;
	}
	
	/**
	 * get the nit
	 * pre:
	 * pos: get the nit
	 * @return int nit
	 */
	public int getNit() {
		return nit;
	}
	
	/**
	 * set the name
	 * pre:
	 * pos: set the name
	 * @param name the name
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * get the name
	 * pre:
	 * pos: get the name
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the nameAdmin
	 * pre:
	 * pos: set the nameAdmin
	 * @param nameAdmin the name admin
	 */
	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}
	
	/**
	 * get the nameAdmin
	 * pre:
	 * pos: get the nameAdmin
	 * @return String nameAdmin
	 */
	public String getNameAdmin() {
		return nameAdmin;
	}
	
	/**
	 * get the products
	 * pre:
	 * pos: get the products
	 * @return the list of products
	 */
	public List<Product> getProducts(){
		return products;
	}
	
	/**
	 * set the products
	 * pre:
	 * pos: set the products
	 * @param products the list of the products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/**
	 * get the clients
	 * pre:
	 * pos: get the clients
	 * @return the list of clients
	 */
	public List<Client> getClients(){
		return clients;
	}
	
	/**
	 * set the clients
	 * pre:
	 * pos: set the clients
	 * @param clients the list of the clients
	 */
	public void setClients(List<Client>clients) {
		this.clients = clients;
	}
	
	/**
	 * add a product
	 * pre:
	 * pos: add a new product
	 * @param code the code of the product
	 * @param cost the cost of the product
	 * @param name the name of the product
	 * @param description the description of the product
	 */
	public void addProduct(int code,int cost,String name, String description) {
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
	
	/**
	 * add a client
	 * pre:
	 * pos: add a new client
	 * @param n the identification number of the client
	 * @param p the phone of the client
	 * @param t the identification type of the client
	 * @param f the first name of the client
	 * @param l the last name of the client
	 * @param a the addres of the client
	 */
	public void addClient(int n, int p, String t, String f, String l, String a) {
		Client x = null;
		try {
			x = new Client(n,p,t,f,l,a);
		} catch (IdentificationException e) {
			
			e.printStackTrace();
		}
		if(clients.isEmpty()) {
			clients.add(x);
		} else {
			
			int i = 0;
			while(i<clients.size() && x.compareTo(clients.get(i)) == 1) {
				i++;
				
			}
			
			if(i<clients.size()) {
				
				clients.add(i,x);

			} else {
				
				clients.add(x);
			}
			
		}
		System.out.println("Client was registered correctly ");
	}
	
	/**
	 * Import products
	 * pre: the file need exists
	 * pos: import products from a file
	 * @param filename the filename
	 * @param separator the separator
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 * @throws FileNotFoundException FileNotFoundException
	 */
	public void importProducts(String filename,String separator) throws IOException,ClassNotFoundException,FileNotFoundException{
		 BufferedReader reader = new BufferedReader(new FileReader(filename));
		 String line = reader.readLine();
		 line = reader.readLine();
		 products.clear();
		 while(line != null) {
			 line.trim();
			 String[] sp = line.split(separator);
			 products.add(new Product(Integer.parseInt(sp[0]),nit,Integer.parseInt(sp[1]),sp[2],sp[3]));
			 line = reader.readLine();
			 
		 }
		 reader.close();
}
	/**
	 * Import clients
	 * pre: the file need exists
	 * pos: import clients from a file
	 * @param filename the filename
	 * @param separator the separator
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 * @throws FileNotFoundException FileNotFoundException
	 */
	public void importClients(String filename,String separator) throws IOException,ClassNotFoundException,FileNotFoundException{
		 BufferedReader reader = new BufferedReader(new FileReader(filename));
		 String line = reader.readLine();
		 line = reader.readLine();
		 clients.clear();
		 while(line != null) {
			 line.trim();
			 String[] sp = line.split(separator);
			 try {
				clients.add(new Client(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),sp[2],sp[3],sp[4],sp[5]));
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (IdentificationException e) {
				
				e.printStackTrace();
			}
			 line = reader.readLine();
			 
		 }
		 reader.close();
}
	/**
	 * Show clients
	 * pre:
	 * pos: show the clients in the restaurant
	 */
	public void showClients() {
		for(int i = 0; i<clients.size();i++) {
		 	
			 System.out.println((i+1) + "." + clients.get(i).getLastName() + " " +
			 clients.get(i).getFirstName() + " " + clients.get(i).getIdentificationNumber());
		 }
	}
		/**
		 * Search a product
		 * pre: 
		 * pos: return the product search or null if this not exists
		 * @param code the code of the product
		 * @return Product n
		 */
		public Product SearchProduct(int code) {
		Product n = null;
		boolean exit = false;
		for(int i=0;i<products.size() && exit == false;i++) {
			
			if(products.get(i).code== code) {
				n = products.get(i);
				exit = true;
			}
		}
		return n;
	}
		/**
		 * Search a client
		 * pre:
		 * pos:return the client search or null if this not exists
		 * @param number the identification number of the client
		 * @return Client c
		 * @throws SearchException when the client doesn exists
		 */
		public Client SearchClient(int number) throws SearchException {
			Client c = null;
			boolean exit = false;
			for(int i=0;i<clients.size() && exit == false;i++) {
				
				if(clients.get(i).identificationNumber== number) {
					c = clients.get(i);
					exit = true;
				}
			}
			if(exit == false) {
				throw new SearchException();
			}
			return c;
		}
		
		/**
		 * update all data
		 * pre:
		 * pos: update all the data of the restaurant
		 * @param nit the nit
		 * @param name the name
		 * @param nameAdmin the name admin
		 * @param lispro the product list
		 * @param clientss the client list
		 */
		 public void updateAllData(int nit,String name,String nameAdmin,List<Product> lispro,List<Client> clientss) {
				 setNit(nit);
				 setName(name);
				 setNameAdmin(nameAdmin);
				 products = lispro;
				 clients = clientss;
				 
			 
			 }
			 
			  
		  }
	

