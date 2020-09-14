package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JuanP
 * 
 * Class Client
 * 
 */
public class Client implements Serializable {
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

}
