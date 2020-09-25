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
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return List<Client> products
	 */
	public List<Client> getClients(){
		return clients;
	}
	
	public void setClients(List<Client>clients) {
		this.clients = clients;
	}
	
	/**
	 * 
	 * @param product
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
	public void showClients() {
		for(int i = 0; i<clients.size();i++) {
		 	
			 System.out.println((i+1) + "." + clients.get(i).getLastName() + " " +
			 clients.get(i).getFirstName() + " " + clients.get(i).getIdentificationNumber());
		 }
	}
	
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
		
		 public void updateAllData(int nit,String name,String nameAdmin,List<Product> lispro,List<Client> clientss) {
				 setNit(nit);
				 setName(name);
				 setNameAdmin(nameAdmin);
				 products = lispro;
				 clients = clientss;
				 
			 
			 }
			 
			  
		  }
	

