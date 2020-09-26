package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.PrintWriter;

import exceptions.ChangeStateException;
import exceptions.IdentificationException;

/**
 * @author JuanP
 * 
 *         Class Client
 * 
 */
public class Client implements Serializable, Comparable<Client> {
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
	 * Constructor of client class pre: pos: build a client instance
	 * 
	 * @param identificationNumber the identification of the client
	 * @param phone                the phone number of the client
	 * @param identificationType   the type of identefication of the client
	 * @param firstName            the firstname of the client
	 * @param lastName             the lastname of the client
	 * @param addres               the addres of the client
	 * @throws IdentificationException the identification is not valid
	 */
	public Client(int identificationNumber, int phone, String identificationType, String firstName, String lastName,
			String addres) throws IdentificationException {
		
			if(identificationType.equalsIgnoreCase("TI") || identificationType.equalsIgnoreCase("CE") || identificationType.equalsIgnoreCase("CC")
					|| identificationType.equalsIgnoreCase("PP")) {
				
				this.identificationNumber = identificationNumber;
				this.phone = phone;
				this.identificationType = identificationType;
				this.firstName = firstName;
				this.lastName = lastName;
				this.addres = addres;
				orders = new ArrayList<Order>();
			}
			
			
			else {
				throw new IdentificationException();
			}
	}

	/**
	 * Add a order pre: pos: add a order
	 * 
	 * @param clientCode    the clientCode
	 * @param restaurantNit the restaurantNit
	 * @param products      the products
	 */
	public void addOrder(int clientCode, int restaurantNit, List<Product> products) {
		Order n = new Order(clientCode, restaurantNit, products);
		orders.add(n);
	}

	/**
	 * set the identification number pre: pos: set an identification number
	 * 
	 * @param identificationNumber the identification number
	 */
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	/**
	 * get the identification number pre: pos: get the identification number
	 * 
	 * @return int identificationNumber
	 */
	public int getIdentificationNumber() {
		return identificationNumber;
	}

	/**
	 * set the phone pre: pos: set a phone
	 * 
	 * @param phone the phone
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * get the phone pre: pos: get the phone
	 * 
	 * @return int phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * set the identification type pre: pos: set the identification type
	 * 
	 * @param identificationType the identification type
	 */
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * get the identification type pre: pos: get the identification type
	 * 
	 * @return String identificationType
	 */
	public String getIdentificationType() {
		return identificationType;
	}

	/**
	 * set the first name pre: pos: set the first name
	 * 
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get the first name pre: pos:get the first name
	 * 
	 * @return String name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set the lastname pre: pos: set the last name
	 * 
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get the lastname pre: pos: get the last name
	 * 
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set addres pre: pos: set the addres
	 * 
	 * @param addres the addres
	 */
	public void setAddres(String addres) {
		this.addres = addres;
	}

	/**
	 * get addres pre: pos:get the addres
	 * 
	 * @return String addres
	 */
	public String getAddres() {
		return addres;
	}

	/**
	 * get the orders of the client pre: pos: get the orders of the client
	 * 
	 * @return the list of orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * change the state of a order pre: the state need be requested or in procces
	 * pos: change the state of a order
	 * 
	 * @param state the state
	 * @param index the index
	 * @throws ChangeStateException when the state is Upper than the state of the
	 *                              order
	 */
	public void changeState(String state, int index) throws ChangeStateException {
		if (orders.get(index).getState().equalsIgnoreCase("REQUESTED") && state.equalsIgnoreCase("IN PROCESS")
				|| state.equalsIgnoreCase("SHIPPED") || state.equalsIgnoreCase("DELIVERED")) {
			orders.get(index).setState(state);
			System.out.println("STATE CHANGED SUCCESSFULLY");
		} else if (orders.get(index).getState().equalsIgnoreCase("IN PROCESS") && state.equalsIgnoreCase("SHIPPED")
				|| state.equalsIgnoreCase("DELIVERED")) {
			orders.get(index).setState(state);
			System.out.println("STATE CHANGED SUCCESSFULLY");
		} else if (orders.get(index).getState().equalsIgnoreCase("SHIPPED") && state.equalsIgnoreCase("DELIVERED")) {
			orders.get(index).setState(state);
			System.out.println("STATE CHANGED SUCCESSFULLY");
		} else {
			throw new ChangeStateException();
		}

	}

	/**
	 * Show the orders pre: pos: show the orders
	 */
	public void showOrders() {

		for (int i = 0; i < orders.size(); i++) {
			System.out.println((i + 1) + "." + orders.get(i).restaurantNit + " " + orders.get(i).code + " "
					+ orders.get(i).date + " " + orders.get(i).clientCode + " " + orders.get(i).state);
			System.out.println("PRODUCTS IN THIS ORDER: ");
			for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
				System.out.println(orders.get(i).getProducts().get(j).code + " "
						+ orders.get(i).getProducts().get(j).name + " " + orders.get(i).getProducts().get(j).description
						+ " " + orders.get(i).getProducts().get(j).cost + " "
						+ orders.get(i).getProducts().get(j).restaurantNit);

			}

		}
	}

	/**
	 * Import the orders pre: the file need exists pos: import the orders of a file
	 * 
	 * @param filename      the filename
	 * @param separator     the separator
	 * @param restaurantNit the restaurant nit
	 * @param r             the restaurant
	 * @param clientCode    the client code
	 * @throws IOException IOException
	 */
	public void importOrders(String filename, String separator, int restaurantNit, Restaurant r, int clientCode)
			throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		line = reader.readLine();
		while (line != null) {
			line.trim();
			ArrayList<Product> products = new ArrayList<>();
			String[] sp = line.split(separator);
			try {
				if (searchOrder(Integer.parseInt(sp[0])) != null) {
					for (int i = 0; i < r.getProducts().size(); i++) {

						if (Integer.parseInt(sp[1]) == r.getProducts().get(i).getCode()) {

							try {
								searchOrder(Integer.parseInt(sp[0])).getProducts().add(new Product(
										Integer.parseInt(sp[1]), restaurantNit, Integer.parseInt(sp[2]), sp[3], sp[4]));
							} catch (NumberFormatException e) {

								e.printStackTrace();
							}

						}
					}

				} else {

					for (int i = 0; i < r.getProducts().size(); i++) {

						if (Integer.parseInt(sp[1]) == r.getProducts().get(i).getCode()) {
							products.add(new Product(Integer.parseInt(sp[1]), restaurantNit, Integer.parseInt(sp[2]),
									sp[3], sp[4]));
							orders.add(new Order(Integer.parseInt(sp[0]), clientCode, restaurantNit, products));

						}
					}
				}
			} catch (NumberFormatException e) {

				e.printStackTrace();
			}

			line = reader.readLine();
		}

		reader.close();
	}

	/**
	 * Search the order pre: pos: return the order if this exists, if not return
	 * null
	 * 
	 * @param code the code
	 * @return Order the order
	 *
	 */
	public Order searchOrder(int code){
		Order o = null;
		boolean exit = false;
		for (int i = 0; i < orders.size() && exit == false; i++) {

			if (orders.get(i).code == code) {
				o = orders.get(i);
				exit = true;
			}
		}
		return o;
	}

	/**
	 * Update all data of the client pre: pos:update all data of the client
	 * 
	 * @param identificationNumber the identification number
	 * @param phone                the phone
	 * @param identificationType   the identification type
	 * @param firstName            the first name
	 * @param lastName             the last name
	 * @param addres               the addres
	 */
	public void updateAllData(int identificationNumber, int phone, String identificationType, String firstName,
			String lastName, String addres) {
		setIdentificationNumber(identificationNumber);
		setPhone(phone);
		setIdentificationType(identificationType);
		setFirstName(firstName);
		setLastName(lastName);
		setAddres(addres);

	}

	@Override
	public int compareTo(Client o) {
		int comp = firstName.compareTo(o.firstName);
		if (comp == 0) {
			comp = lastName.compareTo(o.lastName);
		}
		return comp;
	}

	/**
	 * sort the orders pre: pos: sort the orders using selection sort, bubble sort
	 * and others sorts
	 */
	public void sortOrder() {
		// SELECTION SORT
		for (int i = 0; i < orders.size(); i++) {
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(i).restaurantNit > orders.get(j).restaurantNit) {
					Order temp = orders.get(i);
					orders.set(i, orders.get(j));
					orders.set(j, temp);
				}
			}
		}

		// BUBBLE SORT
		for (int i = 0; i < orders.size(); i++) {
			for (int j = 0; j < orders.size() - 1; j++) {

				if (orders.get(j).clientCode < orders.get(j + 1).clientCode) {
					Order temp = orders.get(j);
					orders.set(j, orders.get(j + 1));
					orders.set(j + 1, temp);
				}

			}
		}
		Collections.sort(orders);
		for (int i = 0; i < orders.get(i).getProducts().size(); i++) {

			Collections.sort(orders.get(i).getProducts());
		}

	}

	/**
	 * export pre: pos: export the information of the orders
	 * 
	 * @param filename  the filename
	 * @param separator the separator
	 * @throws IOException IOException
	 */
	public void export(String filename, String separator) throws IOException {
		sortOrder();
		PrintWriter pw = new PrintWriter(filename);
		String msg = "RESTAURANTNIT" + separator + "CLIENTCODE" + separator + "DATE" + separator + "CODE PRODUCT";
		pw.println(msg);
		for (int i = 0; i < orders.size(); i++) {

			for (int j = 0; j < orders.get(i).getProducts().size(); j++) {

				pw.println((i + 1) + orders.get(i).getProducts().get(j).getRestaurantNit() + separator
						+ orders.get(i).getClientCode() + separator + orders.get(i).date + separator
						+ orders.get(i).getProducts().get(j).getCode());
			}

		}

		System.out.println("EXPORTED SUCCESFULY");
		pw.close();
	}

	public String toString() {
		String info = "";
		info += identificationNumber + " " + phone + " " + identificationType + " " + firstName + " " + lastName + " "
				+ addres;
		return info;
	}

}
