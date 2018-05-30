package caixeiroviajante;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	private ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
			new City("Boston", 42.3601, -71.0589),
			new City("Houston", 29.7604, -95.3698),
			new City("Austin", 30.2672, -97.7431),
			new City("San Francisco", 37.7749, -122.4194),
			new City("Denver", 39.7392, -104.9903),
			new City("Los Angeles", 34.0522, -118.2437),
			new City("Chicago", 41.8781, -87.6298),
			new City("New York", 40.7128, -74.0059),
			new City("Dallas", 32.7767, -96.7970),
			new City("Seatle", 47.6062, -122.3321)
			
	));
			
	public static void main(String[] args) {
		Driver driver = new Driver();
		ArrayList<City> cities = new ArrayList<City>();
		cities.addAll(driver.initialCities);
		driver.printShortestRoute(new NearestNeighbor().findShortestRoute(cities));
		
	}
	private void printShortestRoute(Route shortestRoute) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Shoutest Route found so far: " + shortestRoute);
		System.out.println("w/ total distance: " + shortestRoute.calculateTotalDistance());
		System.out.println("---------------------------------------------------------------------------");
		
    }

}