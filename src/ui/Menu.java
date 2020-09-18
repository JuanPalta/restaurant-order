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
	option = Integer.parseInt(sc.nextLine());
	switch(option){
	
	case REGISTER:
		System.out.println("WHAT DO YOU WANT TO REGISTER?");
		System.out.println("1.RESTAURANT" + "\n" + "2.CLIENT" + "\n" + "3.ORDER" + "\n" + "4.PRODUCT");
		int optionR = Integer.parseInt(sc.nextLine());
		int index = 0;
		int indexc = 0;
		switch(optionR) {
		case 1:
			System.out.println("Insert the name of the restaurant");
			String name = sc.nextLine();
			System.out.println("Insert the nameAdmin");
			String nameAdmin = sc.nextLine();
			System.out.println("Insert the nit");
			int nit = Integer.parseInt(sc.nextLine());
			restaurantA.registerRestaurant(nit,name,nameAdmin);
			break;
			
		case 2:
			restaurantA.showRestaurants();
			System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A CLIENT: ");
			 index = Integer.parseInt(sc.nextLine());
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
			restaurantA.getRestaurants().get(index-1).addClient(n,p,t,f,l,a);
			restaurantA.saveRestaurants();
			break;
		case 3:
			 restaurantA.showRestaurants();
			 System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A ORDER: ");
			 index = Integer.parseInt(sc.nextLine())-1;
			 restaurantA.getRestaurants().get(index).showClients();
			 System.out.println("PUT THE INDEX OF THE CLIENT TO REGISTER A ORDER: ");
			 indexc = Integer.parseInt(sc.nextLine())-1;
			 System.out.println("Insert how many different products you will add");
			 int many = Integer.parseInt(sc.nextLine());
			 ArrayList<Product> products = new ArrayList<Product>();
			 int clientcode = restaurantA.getRestaurants().get(index).getClients().get(indexc).getIdentificationNumber();
			 int restNit = restaurantA.getRestaurants().get(index).getNit();
			 int code = 0;
			 int count=0;
			 int cNumber = 0;
			 for(int i=0;i<many ;i++) {
				 System.out.println((i+1)+ "." + "PRODUCT");
				 System.out.println("INSERT THE CODE OF THE PRODUCT: ");
				 code = Integer.parseInt(sc.nextLine());
				 System.out.println("INSERT THE QUANTITY OF THIS PRODUCT: ");
				 cNumber = Integer.parseInt(sc.nextLine());
				 for(int j =0;j<restaurantA.getRestaurants().get(index).getProducts().size();j++) {
					 
					 	if(restaurantA.getRestaurants().get(index).getProducts().get(j).getCode() == code) {
						System.out.println("YEESS");
						
						for(int k = 0;k<cNumber;k++) {
							Product nproduct = new Product(code,restNit,restaurantA.getRestaurants().get(index).getProducts().get(0).getCost(),
							restaurantA.getRestaurants().get(index).getProducts().get(0).getName(),restaurantA.getRestaurants().get(index).getProducts().get(0).getDescription());
							products.add(nproduct);
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
			restaurantA.showRestaurants();
			System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A PRODUCT: ");
			index = Integer.parseInt(sc.nextLine());
			System.out.println("INSERT CODE:");
			int codeP = Integer.parseInt(sc.nextLine());
			System.out.println("INSERT COST: ");
			int costP = Integer.parseInt(sc.nextLine());
			System.out.println("INSERT THE NAME: ");
			String nameP = sc.nextLine();
			System.out.println("INSERT THE DESCRIPTION: ");
			String descriptionP = sc.nextLine();
			restaurantA.getRestaurants().get(index-1).addProduct(codeP,costP,nameP,descriptionP);
			restaurantA.saveRestaurants();
			break;
		}
		
			break;
		
	case UPDATE_DATA:
		System.out.println("WHAT DO YOU WANT UPDATE: " + "\n" + "1.RESTAURANT" + "\n" + "2.CLIENT" + "\n" + "3.PRODUCT" + "\n" + "4.ORDER");
		int optionup = Integer.parseInt(sc.nextLine());
		switch(optionup) {
			
		case 1:
			 System.out.println("INSERT THE NIT OF THE RESTAURANT TO SEARCH");
			 int nitR = Integer.parseInt(sc.nextLine());
			 System.out.println("CHOOSE AN OPTION :" + "1.UPDATE ALL" + " " + "2.UPDATE NAME" + " " + "3.UPDATE NAME ADMIN" + " " +
					 			" " + "4.UPDATE NIT"+ " " + "5.UPDATE THE PRODUCTS" + " " + "6.UPDATE THE CLIENTS");
			 int optionr = Integer.parseInt(sc.nextLine());
			 switch(optionr) {
			 case 1:
				 System.out.println("INSERT THE NIT: ");
				 int nit = Integer.parseInt(sc.nextLine());
				 System.out.println("INSERT THE NAME: ");
				 String name = sc.nextLine();
				 System.out.println("INSERT NAME ADMIN: ");
				 String nameAdmin = sc.nextLine();
				 int opProduct = 0;
				 int opClients = 0;
				 ArrayList<Product> p = new ArrayList<Product>();
				 ArrayList<Client> c = new ArrayList<Client>();
				 while(opProduct != 2) {
					 System.out.println("WHICH PRODUCTS HAVE THIS RESTAURANT ");
					 System.out.println("PRESS 1 TO ADD A PRODUCT " + " " + "2 TO EXIT");
					 opProduct = Integer.parseInt(sc.nextLine());
					 if(opProduct == 1) {
						 
						 System.out.println("PRODUCT : ");
						 System.out.println("INSERT THE CODE: ");
						 int code = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE COST: ");
						 int cost = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE NAME: ");
						 String namep = sc.nextLine();
						 System.out.println("INSERT THE DESCRIPTION: ");
						 String description = sc.nextLine();
						 p.add(new Product(code,restaurantA.searchRestaurant(nitR).getNit(),cost,namep,description));
					 }
					
				 }
				 while(opClients != 2) {
					 System.out.println("WHICH CLIENTS HAVE THIS RESTAURANT ");
					 System.out.println("PRESS 1 TO ADD A CLIENT " + " " + "2 TO EXIT");
					 opClients = Integer.parseInt(sc.nextLine());
					 if(opClients == 1) {
						 System.out.println("CLIENT : ");
						 System.out.println("INSERT THE IDENTIFICATION: ");
						 int identification = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE PHONE: ");
						 int phone = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE TYPE OF IDENTIFICATION: TI/CC/CE/PP");
						 String type = sc.nextLine();
						 System.out.println("INSERT THE FIRTSNAME: ");
						 String firstName = sc.nextLine();
						 System.out.println("INSERT THE LASTNAME: ");
						 String lastName = sc.nextLine();
						 System.out.println("INSERT THE ADDRES: ");
						 String addres = sc.nextLine();
						 c.add(new Client(identification,phone,type,firstName,lastName,addres));
					 }
					 
				 }
				 if(restaurantA.searchRestaurant(nitR) != null	) {
					restaurantA.searchRestaurant(nitR).updateAllData(nit, name, nameAdmin, p, c);
					System.out.println("UPDATE SUCCESFULY");
					restaurantA.saveRestaurants();
				 } else {
					 System.out.println("THE NIT DONT FOUND");
					 
				 }
				
				 
				 break;
				 
			 case 2:
				 
				if(restaurantA.searchRestaurant(nitR) != null) {
					 System.out.println("PUT THE NAME: ");
					 name = sc.nextLine();
					 restaurantA.searchRestaurant(nitR).setName(name);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				}
				 else {
					 System.out.println("F BRO");
				 }
			break;
			
			 case 3:
				 if(restaurantA.searchRestaurant(nitR) != null) {
					 System.out.println("PUT THE ADMINNAME: ");
					 name = sc.nextLine();
					 restaurantA.searchRestaurant(nitR).setNameAdmin(name);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				}
				 else {
					 System.out.println("F BRO");
				 }
		
				 break;
			 case 4:
				 
				 if(restaurantA.searchRestaurant(nitR) != null) {
					 System.out.println("PUT THE NIT: ");
					 int nitf = Integer.parseInt(sc.nextLine());
					 restaurantA.searchRestaurant(nitR).setNit(nitf);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				}
				 else {
					 System.out.println("F BRO");
				 }
				 break;
			 case 5:
				 opProduct = 0;
				 p = new ArrayList<Product>();
				 while(opProduct != 2) {
					 System.out.println("WHICH PRODUCTS HAVE THIS RESTAURANT ");
					 System.out.println("PRESS 1 TO ADD A PRODUCT " + " " + "2 TO EXIT");
					 opProduct = Integer.parseInt(sc.nextLine());
					 if(opProduct == 1) {
						 
						 System.out.println("PRODUCT : ");
						 System.out.println("INSERT THE CODE: ");
						 int code = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE COST: ");
						 int cost = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE NAME: ");
						 String namep = sc.nextLine();
						 System.out.println("INSERT THE DESCRIPTION: ");
						 String description = sc.nextLine();
						 p.add(new Product(code,restaurantA.searchRestaurant(nitR).getNit(),cost,namep,description));
					 }
				 }
				 	if(restaurantA.searchRestaurant(nitR) != null	) {
						restaurantA.searchRestaurant(nitR).setProducts(p);
						System.out.println("UPDATE SUCCESFULY");
						restaurantA.saveRestaurants();
					 } else {
						 System.out.println("THE NIT DONT FOUND");
						 
					 }
				 
				 break;
			 case 6:
				 opClients = 0;
				 c = new ArrayList<Client>();
				 while(opClients != 2) {
					 System.out.println("WHICH CLIENTS HAVE THIS RESTAURANT ");
					 System.out.println("PRESS 1 TO ADD A CLIENT " + " " + "2 TO EXIT");
					 opClients = Integer.parseInt(sc.nextLine());
					 if(opClients == 1) {
						 System.out.println("CLIENT : ");
						 System.out.println("INSERT THE IDENTIFICATION: ");
						 int identification = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE PHONE: ");
						 int phone = Integer.parseInt(sc.nextLine());
						 System.out.println("INSERT THE TYPE OF IDENTIFICATION: TI/CC/CE/PP");
						 String type = sc.nextLine();
						 System.out.println("INSERT THE FIRTSNAME: ");
						 String firstName = sc.nextLine();
						 System.out.println("INSERT THE LASTNAME: ");
						 String lastName = sc.nextLine();
						 System.out.println("INSERT THE ADDRES: ");
						 String addres = sc.nextLine();
						 c.add(new Client(identification,phone,type,firstName,lastName,addres));
					 }
					 
				 }
				 if(restaurantA.searchRestaurant(nitR) != null	) {
					restaurantA.searchRestaurant(nitR).setClients(c);
					System.out.println("UPDATE SUCCESFULY");
					restaurantA.saveRestaurants();
				 } else {
					 System.out.println("THE NIT DONT FOUND");
					 
				 }
				 
				 break;
				 
		
		}  
		break;
		
		case 2:
			 restaurantA.showRestaurants();
			 System.out.println("PUT THE INDEX OF THE RESTAURANT TO SEARCH A CLIENT: ");
			 index = Integer.parseInt(sc.nextLine())-1;
			 System.out.println("INSERT THE IDENTIFICATION NUMBER OF THE CLIENT TO SEARCH");
			 int in = Integer.parseInt(sc.nextLine());
			 System.out.println("CHOOSE AN OPTION :" + "1.UPDATE ALL" + " " + "2.UPDATE FIRSTNAME AND LASTNAME" + " " + "3.UPDATE IDENTIFICATION NUMBER" + " " +
					 			 " " + "4.UPDATE IDENTIFICATION TYPE"+ " " + "5.UPDATE ADDRES");
			 int option2 = Integer.parseInt(sc.nextLine());
			 switch(option2) {
			 
			 case 1:
				 if(restaurantA.getRestaurants().get(index).SearchClient(in) != null) {
					 
					 System.out.println("INSERT THE IDENTIFICATION NUMBER: ");
					 int nin = Integer.parseInt(sc.nextLine());
					 System.out.println("INSERT THE PHONE NUMBER: ");
					 int phone = Integer.parseInt(sc.nextLine());
					 System.out.println("INSERT THE IDENTIFICATION TYPE: TI/CC/CE/PP ");
					 String type = sc.nextLine();
					 System.out.println("INSERT THE FIRST NAME: ");
					 String fname = sc.nextLine();
					 System.out.println("INSERT THE LAST NAME: ");
					 String lname = sc.nextLine();
					 System.out.println("INSERT THE ADDRES: ");
					 String addres = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchClient(in).updateAllData(nin,phone,type,fname,lname,addres);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 } else {
					 
					 System.err.println("DONT EXIST");
				 }
				 ;
				 
				 break;
				 
			 case 2:
				 if(restaurantA.getRestaurants().get(index).SearchClient(in) != null) {
					 System.out.println("INSERT THE FIRST NAME: ");
					 String fname = sc.nextLine();
					 System.out.println("INSERT THE LAST NAME: ");
					 String lname = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchClient(in).setFirstName(fname);
					 restaurantA.getRestaurants().get(index).SearchClient(in).setLastName(lname);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
				 }
				 break;
				 
			 case 3:
				 
				 if(restaurantA.getRestaurants().get(index).SearchClient(in) != null) {
					 System.out.println("INSERT THE IDENTIFICATION NUMBER ");
					 int n = Integer.parseInt(sc.nextLine());
					 restaurantA.getRestaurants().get(index).SearchClient(in).setIdentificationNumber(n);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
				 }
				 break;
				 
			 case 4:
				 if(restaurantA.getRestaurants().get(index).SearchClient(in) != null) {
					 System.out.println("INSERT THE IDENTIFICATION TYPE: TI/CC/CE/PP");
					 String type = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchClient(in).setIdentificationType(type);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
				 }
				 break;
			 case 5:
				 if(restaurantA.getRestaurants().get(index).SearchClient(in) != null) {
					 System.out.println("INSERT THE ADDRES");
					 String addres = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchClient(in).setAddres(addres);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
				 }
				 break;
			 }
			break;
			
		case 3:
			restaurantA.showRestaurants();
			System.out.println("PUT THE INDEX OF THE RESTAURANT TO SEARCH A PRODUCT: ");
			 index = Integer.parseInt(sc.nextLine())-1;
			 System.out.println("INSERT THE CODE OF THE PRODUCT TO SEARCH");
			 int code = Integer.parseInt(sc.nextLine());
			 System.out.println("CHOOSE AN OPTION :" + "1.UPDATE ALL" + " " + "2.UPDATE CODE" + " " + "3.UPDATE COST" + " " +
					 			 " " + "4.UPDATE NAME"+ " " + "5.UPDATE DESCRIPTION");
			 int optionP = Integer.parseInt(sc.nextLine());
			 switch(optionP) {
			 
			 case 1:
				 if(restaurantA.getRestaurants().get(index).SearchProduct(code) != null) {
					 System.out.println("INSERT THE CODE");
					 int codep = Integer.parseInt(sc.nextLine());
					 System.out.println("INSERT THE COST");
					 int costp = Integer.parseInt(sc.nextLine());
					 System.out.println("INSERT THE NAME");
					 String namep = sc.nextLine();
					 System.out.println("INSERT THE DESCRIPTION"); 
					 String description = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchProduct(code).updateAllData(codep,costp,namep,description);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
					 
				 }
				 break;
				 
			 case 2:
				 if(restaurantA.getRestaurants().get(index).SearchProduct(code) != null) {
					 System.out.println("INSERT THE CODE");
					 int codep = Integer.parseInt(sc.nextLine());
					 restaurantA.getRestaurants().get(index).SearchProduct(code).setCode(codep);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
					 
				 }
				 
				 break;
				 
			 case 3:
				 if(restaurantA.getRestaurants().get(index).SearchProduct(code) != null) {
					 System.out.println("INSERT THE COST");
					 int costp = Integer.parseInt(sc.nextLine());
					 restaurantA.getRestaurants().get(index).SearchProduct(code).setCost(costp);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
					 
				 }
				 break;
				 
			 case 4:
				 if(restaurantA.getRestaurants().get(index).SearchProduct(code) != null) {
					 System.out.println("INSERT THE NAME");
					 String namep = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchProduct(code).setName(namep);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
					 
				 }
				 break;
				 
			 case 5:
				 if(restaurantA.getRestaurants().get(index).SearchProduct(code) != null) {
					 System.out.println("INSERT THE DESCRIPTION");
					 String description = sc.nextLine();
					 restaurantA.getRestaurants().get(index).SearchProduct(code).setDescription(description);
					 System.out.println("UPDATE SUCCESFULY");
					 restaurantA.saveRestaurants();
				 }
				 else {
					 System.err.println("DONT EXIST");
					 
				 }
				 break;
			 }
			break;
			
		case 4:
			
			break;
		
		
		}
		break;
		
		
	case CHANGE_STATE:
		
		 restaurantA.showRestaurants();
		 System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A ORDER: ");
		 index = Integer.parseInt(sc.nextLine())-1;
		 restaurantA.getRestaurants().get(index).showClients();
		 System.out.println("PUT THE INDEX OF THE CLIENT TO CHANGE STATE A ORDER: ");
		 indexc = Integer.parseInt(sc.nextLine())-1;
		 restaurantA.getRestaurants().get(index).getClients().get(indexc).showOrders();
		 int count = 0;
		 for(int i = 0;i<restaurantA.getRestaurants().get(index).getClients().get(indexc).getOrders().size();i++) {
			if(restaurantA.getRestaurants().get(index).getClients().get(indexc).getOrders().get(i).getRestaurantNit() == restaurantA.getRestaurants().get(index).getNit()) {
				count++;
				}
			
		 }
		 if(count == restaurantA.getRestaurants().get(index).getClients().get(indexc).getOrders().size() ) {
			 System.out.println("PUT THE INDEX OF THE ORDER TO CHANGE THE STATE");
			 int indexS = Integer.parseInt(sc.nextLine())-1;
			 System.out.println("PUT THE STATE - IN PROCESS OR SENT");
			 String state = sc.nextLine();
			 restaurantA.getRestaurants().get(index).getClients().get(indexc).changeState(state, indexS);
		 }
		break;
		
	case SAVE:
		restaurantA.saveRestaurants();
		System.out.println("You save correctly");
		break;
	
	case IMPORT:
		System.out.println("WHAT INFORMATION YOU WANT IMPORT : " + "\n" + "1.RESTAURANTS" + "\n" + "2.CLIENTS" + "\n" + "3.PRODUCTS" + "\n" + "4.ORDERS");
		int optionImport = Integer.parseInt(sc.nextLine());
		System.out.println("PUT THE PATH OF THE FILE TO IMPORT: ");
		String path = sc.nextLine();
		System.out.println("PUT THE SEPARATOR OF THE FILE TO IMPORT: ");
		String separator = sc.nextLine();
		int indexcl = 0;
		switch(optionImport) {
		
		case 1: 
			try {
				
				restaurantA.importRestaurants(path,separator);
				System.out.println("Import succesfuly");
			} catch(FileNotFoundException fne) {
			
				System.err.println(fne.getStackTrace());
				
			}
			
			break;
			
		case 2:
			
			restaurantA.showRestaurants();
			System.out.println("INSERT THE INDEX TO THE RESTAURANT TO IMPORT CLIENTS");
			indexcl = Integer.parseInt(sc.nextLine());
			try {
				restaurantA.getRestaurants().get(indexcl).importClients(path, separator);
			} catch(FileNotFoundException fne){
				
				System.err.println(fne.getStackTrace());
			}
			
			break;
			
		case 3:
			
			restaurantA.showRestaurants();
			System.out.println("INSERT THE INDEX TO THE RESTAURANT TO IMPORT PRODUCTS");
			indexcl = Integer.parseInt(sc.nextLine());
			try {
				restaurantA.getRestaurants().get(indexcl).importProducts(path, separator);
			} catch(FileNotFoundException fne){
				
				System.err.println(fne.getStackTrace());
			}
			
			break;
			
		case 4:
			
			break;
			
		default:
			
			break;
		
		}
		
		
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
