package ui;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

	public final static int REGISTER = 1;
	public final static int UPDATE_DATA =2;
	public final static int CHANGE_STATE=3;
	public final static int SAVE = 4;
	public final static int IMPORT=5;
	public final static int EXPORT=6;
	public final static int SHOW = 7;
	public final static int FIND_CLIENT = 8;
	public final static int EXIT = 9;
	public final static String principal = "1.REGISTER" + "\n" + "2.UPDATE DATA" + "\n"+ "3.CHANGE STATE" + "\n" + "4.SAVE" + "\n" + "5.IMPORT" + "\n" + 
										   "6.EXPORT" + "\n" + "7.SHOW IN SCREEN" + "\n" + "8.FIND CLIENT " + "\n" + "9.EXIT";
	Scanner sc = new Scanner(System.in);
	RestaurantAssociation restaurantA;
	public Menu() throws FileNotFoundException, ClassNotFoundException, IOException {
	
		restaurantA = new RestaurantAssociation();
		
	}
	
	public void showMenu() throws ClassNotFoundException, IOException {
	
	int option = 0;
	while(option != EXIT) {
	System.out.println("WELCOME TO THE RESTAURANTS PROGRAM" + "\n" + "CHOOSE AN OPTION: ");
	System.out.println(principal);
	option = sc.nextInt();
	switch(option){
	
	case REGISTER:
		System.out.println("WHAT DO YOU WANT TO REGISTER?");
		System.out.println("1.RESTAURANT" + "\n" + "2.CLIENT" + "\n" + "3.ORDER" + "\n" + "4.PRODUCT");
		int optionR = sc.nextInt();
		int index = 0;
		int indexc = 0;
		switch(optionR) {
		case 1:
			restaurantA.registerRestaurant();
			break;
			
		case 2:
			for(int i = 0; i<restaurantA.getRestaurants().size();i++) {
				
				System.out.println((i+1) + "." + restaurantA.getRestaurants().get(i).getName() + " " + restaurantA.getRestaurants().get(i).getNameAdmin() + " " + restaurantA.getRestaurants().get(i).getNit());
			}
			System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A CLIENT: ");
			 index = sc.nextInt();
			restaurantA.getRestaurants().get(index-1).addClient();
			restaurantA.saveRestaurants();
			break;
		case 3:
			for(int i = 0; i<restaurantA.getRestaurants().size();i++) {
				
				System.out.println((i+1) + "." + restaurantA.getRestaurants().get(i).getName() + " " + restaurantA.getRestaurants().get(i).getNameAdmin() + " " + restaurantA.getRestaurants().get(i).getNit());
			}
			 System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A ORDER: ");
			 index = sc.nextInt()-1;
			 
			 for(int i = 0; i<restaurantA.getRestaurants().get(index).getClients().size();i++) {
				 	
				 System.out.println((i+1) + "." + restaurantA.getRestaurants().get(index).getClients().get(i).getLastName() + " " +
				 restaurantA.getRestaurants().get(index).getClients().get(i).getFirstName() + " " + restaurantA.getRestaurants().get(index).getClients().get(i).getIdentificationNumber());
			 }
			 System.out.println("PUT THE INDEX OF THE CLIENT TO REGISTER A ORDER: ");
			 indexc = sc.nextInt()-1;
			 System.out.println("Insert how many different products you will add");
			 int many = sc.nextInt();
			 ArrayList<Product> products = new ArrayList<Product>();
			 int clientcode = restaurantA.getRestaurants().get(index).getClients().get(indexc).getIdentificationNumber();
			 int restNit = restaurantA.getRestaurants().get(index).getNit();
			 int code = 0;
			 int count=0;
			 int cNumber = 0;
			 for(int i=0;i<many ;i++) {
				 System.out.println((i+1)+ "." + "PRODUCT");
				 System.out.println("INSERT THE CODE OF THE PRODUCT: ");
				 code = sc.nextInt();
				 System.out.println("INSERT THE QUANTITY OF THIS PRODUCT: ");
				 cNumber = sc.nextInt();
				 for(int j =0;j<restaurantA.getRestaurants().get(index).getProducts().size();j++) {
					 
					 	if(restaurantA.getRestaurants().get(index).getProducts().get(j).getCode() == code) {
						System.out.println("YEESS");
						
						for(int k = 0;k<cNumber;k++) {
							Product n = new Product(code,restNit,restaurantA.getRestaurants().get(index).getProducts().get(0).getCost(),
							restaurantA.getRestaurants().get(index).getProducts().get(0).getName(),restaurantA.getRestaurants().get(index).getProducts().get(0).getDescription());
							products.add(n);
							count++;
						}
					 }
					 
				 }
			 }
			 if(count==0) {
				 System.err.println("This restaurant dont have a product with this code");
			 }
			 else {
				 
				 restaurantA.getRestaurants().get(index).getClients().get(indexc).addOrder(clientcode, restNit, products);
				 System.out.println("Products with a correct code added correctly");
				 restaurantA.saveRestaurants();
			 }
	
			break;
			
		case 4:
			for(int i = 0; i<restaurantA.getRestaurants().size();i++) {
				
			System.out.println((i+1) + "." + restaurantA.getRestaurants().get(i).getName() + " " + restaurantA.getRestaurants().get(i).getNameAdmin() + " " + restaurantA.getRestaurants().get(i).getNit());
			}
			System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A PRODUCT: ");
			index = sc.nextInt();
			restaurantA.getRestaurants().get(index-1).addProduct();
			restaurantA.saveRestaurants();
			break;
		}
		
			break;
		
	case UPDATE_DATA:
		
		break;
		
	case CHANGE_STATE:
		
		break;
		
	case SAVE:
		
		break;
	
	case IMPORT:
		
		break;
	
	case EXPORT:
		
		break;
	
	case SHOW:
		
		break;
	
	case FIND_CLIENT:
		
		break;
		
		default:
			System.out.println("THANKS FOR USE THE PROGRAM");
		break;
		
	}
	}
	sc.close();
	} 
	
}
