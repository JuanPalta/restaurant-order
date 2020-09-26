package model;
import java.util.Comparator;
/**
 * The Comparator of restaurants
 * @author JuanP
 *
 */
public class RestaurantComparator implements Comparator<Restaurant> {
	
	@Override
	public int compare(Restaurant r1, Restaurant r2) {
		int comp;
		String nom1 = r1.getName();
		String nom2 = r2.getName();
		comp = nom1.compareTo(nom2);
		return comp;
	}
}
