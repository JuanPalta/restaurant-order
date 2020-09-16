package model;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
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
	 * 
	 * @return List<Restaurant>
	 */
	public List<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	/**
	 * pre:
	 * pos:
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public  void registerRestaurant(int nit, String name, String nameAdmin) throws ClassNotFoundException, IOException {
		restaurants.add(new Restaurant(nit,name,nameAdmin));
		System.out.println("the restaurant was registered correctly");
		saveRestaurants();
	}
	
	/**
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void saveRestaurants() throws IOException,ClassNotFoundException{
		 
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RESTAURANT_LIST));
		 oos.writeObject(restaurants);
		 oos.close();
	 
 }
	
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
	
	public void showRestaurants() {
		
		for(int i = 0; i<restaurants.size();i++) {
			
			System.out.println((i+1) + "." + restaurants.get(i).getName() + " " + restaurants.get(i).getNameAdmin() + " " + restaurants.get(i).getNit());
		}
	}
	
	public Restaurant searchRestaurant(int nit) {
		Restaurant r = null;
		boolean exit = false;
		for(int i=0;i<restaurants.size() && exit == false;i++) {
			
			if(restaurants.get(i).nit== nit) {
				r = restaurants.get(i);
				exit = true;
			}
		}
		return r;
	}
	
	
}
