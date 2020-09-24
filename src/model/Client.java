package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JuanP
 * 
 * Class Client
 * 
 */
public class Client implements Serializable,Comparable<Client> {
	public static final long serialVersionUID = 1;
	/** ATRIBUTES */
	int identificationNumber;
	int phone;
	String identificationType;
	String firstName;
	String lastName;
	String addres;
	List<Order> orders;
	
	/**
	 * Constructor of client class
	 * pre:
	 * pos: build a client instance
	 * @param identificationNumber the identification of the client
	 * @param phone the phone number of the client
	 * @param identificationType the type of identefication of the client
	 * @param name the name of the client
	 * @param addres the addres of the client
	 */
	public Client(int identificationNumber, int phone, String identificationType, String firstName, String lastName, String addres) {

		this.identificationNumber = identificationNumber;
		this.phone = phone;
		this.identificationType = identificationType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addres = addres;
		orders = new ArrayList<Order>();
		
	}
	
	/**
	 * 
	 * @param clientCode
	 * @param restaurantNit
	 * @param products
	 */
	public void addOrder(int clientCode,int restaurantNit, List<Product> products) {
		Order n = new Order(clientCode,restaurantNit,products);
		orders.add(n);
	}
	
	/**
	 * pre:
	 * pos:
	 * @param identificationNumber
	 */
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int identificationNumber
	 */
	public int getIdentificationNumber() {
		return identificationNumber;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param phone
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return int phone
	 */
	public int getPhone() {
		return phone;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param identificationType
	 */
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return String identificationType
	 */
	public String getIdentificationType() {
		return identificationType;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return String name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * pre:
	 * pos:
	 * @param addres
	 */
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return String addres
	 */
	public String getAddres() {
		return addres;
	}
	
	/**
	 * pre:
	 * pos:
	 * @return List<Order> products
	 */
	public List<Order> getOrders(){
		return orders;
	}
	
	/**
	 * 
	 * @param state
	 * @param index
	 */
	public void changeState(String state, int index) {
		if(orders.get(index).getState().equalsIgnoreCase("REQUESTED") && state.equalsIgnoreCase("IN PROCESS") || state.equalsIgnoreCase("SENT")) {
			
			orders.get(index).setState(state);
		} else if(orders.get(index).getState().equalsIgnoreCase("IN PROCESS") && state.equalsIgnoreCase("SENT")){
			orders.get(index).setState(state);
		} else {
			
			System.err.println("You cant change in reverse");
		}
		
	}
	
	public void showOrders() {
		
		for(int i = 0; i<orders.size();i++) {
			System.out.println((i+1) + "." + orders.get(i).restaurantNit + " " +
			orders.get(i).code + " " + orders.get(i).date + " " + orders.get(i).clientCode + " " + orders.get(i).state);
			System.out.println("PRODUCTS IN THIS ORDER: ");
			for(int j = 0; j<orders.get(i).getProducts().size();j++) {
			 System.out.println(orders.get(i).getProducts().get(j).code + " " + orders.get(i).getProducts().get(j).name + " " + orders.get(i).getProducts().get(j).description + " "
					 			 + orders.get(i).getProducts().get(j).cost + " " + orders.get(i).getProducts().get(j).restaurantNit);
				
			}
			
		}
	}

	public void importOrders(String filename,String separator,int restaurantNit,Restaurant r,int clientCode) throws IOException {
		 BufferedReader reader = new BufferedReader(new FileReader(filename));
		 String line = reader.readLine();
		 line = reader.readLine();
		 while(line != null) {
			 line.trim();
			 ArrayList<Product> products = new ArrayList<>();
			 String[] sp = line.split(separator);
			 if(SearchOrder(Integer.parseInt(sp[0])) != null) {
			 for(int i=0;i<r.getProducts().size();i++) {
				 
				 if(Integer.parseInt(sp[1]) == r.getProducts().get(i).getCode()) {
					  
				 SearchOrder(Integer.parseInt(sp[0])).getProducts().add(new Product(Integer.parseInt(sp[1]),restaurantNit,Integer.parseInt(sp[2]),sp[3],sp[4]));
					 
				 }
			 }
			 
			 } 
			 else {
				 
				 for(int i=0;i<r.getProducts().size();i++) {
					 
					 if(Integer.parseInt(sp[1]) == r.getProducts().get(i).getCode()) {
						 products.add(new Product(Integer.parseInt(sp[1]),restaurantNit,Integer.parseInt(sp[2]),sp[3],sp[4]));
						 orders.add(new Order(Integer.parseInt(sp[0]),clientCode,restaurantNit,products)); 
						 
					 }
					 }
				 }
				
				 
			 line = reader.readLine();
			 }
			 
		 
		 reader.close();
	}
	
		public Order SearchOrder(int code) {
		Order o = null;
		boolean exit = false;
		for(int i=0;i<orders.size() && exit == false;i++) {
			
			if(orders.get(i).code == code) {
				o = orders.get(i);
				exit = true;
			}
		}
		return o;
	}
		
		 public void updateAllData(int identificationNumber, int phone, String identificationType, String firstName, String lastName, String addres) {
				 setIdentificationNumber(identificationNumber);
				 setPhone(phone);
				 setIdentificationType(identificationType);
				 setFirstName(firstName);
				 setLastName(lastName);
				 setAddres(addres);
		
		  }

		@Override
		public int compareTo(Client o) {
			int comp = lastName.compareTo(o.lastName);
			if(comp == 0) {
				comp = firstName.compareTo(o.firstName);
			}
			return comp;
		}
	
	

}
