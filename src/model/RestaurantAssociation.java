package model;
import java.util.ArrayList;

import java.util.List;

import exceptions.SearchException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
/**
 * 
 * @author JuanP
 * 
 * Class RestaurantAssociation
 *
 */
public class RestaurantAssociation {
	public static final String RESTAURANT_LIST = "data/restaurants.jm";
	private List<Restaurant> restaurants;
	/**
	 * Constructor of class RestaurantAssociation
	 * pre:
	 * pos: create a RestaurantAssociation instance
	 * @throws IOException IOException
	 * @throws FileNotFoundException FileNotFoundException 
	 * @throws ClassNotFoundException ClassNotFoundException
	 */
	public RestaurantAssociation() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(RESTAURANT_LIST);
		if(file.exists()) {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			 @SuppressWarnings("unchecked")
			ArrayList<Restaurant> arrayList = (ArrayList<Restaurant>) ois.readObject();
			 restaurants = arrayList;
			 ois.close();
		}
		else {
			restaurants = new ArrayList<Restaurant>();
		}
		
	}
	
	/**
	 * get Restaurants
	 * pre:
	 * pos: get the list of the restaurants
	 * @return the list of restaurants
	 */
	public List<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	/**
	 * Register a restaurant
	 * pre:
	 * pos: register succesfuly a restaurant
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 * @param nit the nit
	 * @param name the name
	 * @param nameAdmin the nameAdmin
	 * 
	 */
	public  void registerRestaurant(int nit, String name, String nameAdmin) throws ClassNotFoundException, IOException {
		restaurants.add(new Restaurant(nit,name,nameAdmin));
		System.out.println("the restaurant was registered correctly");
		saveRestaurants();
	}
	
	/**
	 * Save the restaurants
	 * pre:
	 * pos: save all the restaurants
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 */
	public void saveRestaurants() throws IOException,ClassNotFoundException{
		 
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RESTAURANT_LIST));
		 oos.writeObject(restaurants);
		 oos.close();
	 
 }
	/**
	 * Import the restaurants
	 * pre: the filename need exists
	 * pos: import the restaurants
	 * @param filename the filename
	 * @param separator the separator
	 * @throws IOException IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 * @throws FileNotFoundException FileNotFoundException
	 */
	public void importRestaurants(String filename,String separator) throws IOException,ClassNotFoundException,FileNotFoundException{
			 BufferedReader reader = new BufferedReader(new FileReader(filename));
			 String line = reader.readLine();
			 line = reader.readLine();
			 restaurants.clear();
			 while(line != null) {
				 line.trim();
				 String[] sp = line.split(separator);
				 restaurants.add(new Restaurant(Integer.parseInt(sp[0]),sp[1],sp[2]));
				 line = reader.readLine();
				 
			 }
			 saveRestaurants();
			 reader.close();
	}
	
	/**
	 * Show the restaurants
	 * pre:
	 * pos : show the restaurants
	 */
	public void showRestaurants() {
		
		for(int i = 0; i<restaurants.size();i++) {
			
			System.out.println((i+1) + "." + restaurants.get(i).getName() + " " + restaurants.get(i).getNameAdmin() + " " + restaurants.get(i).getNit());
		}
	}
	
	/**
	 * Searh the restaurant
	 * pre:
	 * pos: return null if the restaurant doesnt exist, retur the restaurant if this exists
	 * @param nit the nit
	 * @return Restaurant r
	 * @throws SearchException the Restaurant doesnt exists
	 */
	public Restaurant searchRestaurant(int nit) throws SearchException {
		Restaurant r = null;
		boolean exit = false;
		for(int i=0;i<restaurants.size() && exit == false;i++) {
			
			if(restaurants.get(i).nit== nit) {
				r = restaurants.get(i);
				exit = true;
			}
		}
		if(exit == false) {
			throw new SearchException();
		}
		return r;
	}
	
	
}
