package ui;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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
			 System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A CLIENT: ");
			 index = sc.nextInt();
			 System.out.println("INSERT THE CODE OF THE PRODUCT: ");
			 int code = sc.nextInt();
			 System.out.println("INSERT THE IDENTIFICATION NUMBER OF THE CLIENT: ");
			 int cNumber = sc.nextInt();
			
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
