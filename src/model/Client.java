package model;

/**
 * @author JuanP
 * 
 * Class Client
 * 
 */
public class Client {
	
	/** ATRIBUTES */
	int identificationNumber;
	int phone;
	String identificationType;
	String name;
	String addres;
	
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
	public Client(int identificationNumber, int phone, String identificationType, String name, String addres) {

		this.identificationNumber = identificationNumber;
		this.phone = phone;
		this.identificationType = identificationType;
		this.name = name;
		this.addres = addres;

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

}
