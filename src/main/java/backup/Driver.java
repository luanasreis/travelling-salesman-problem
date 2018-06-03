//package backup;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Driver {
//	private ArrayList<CityCoordinates> initialCities = new ArrayList<CityCoordinates>(Arrays.asList(
//			new CityCoordinates("Boston", 42.3601, -71.0589),
//			new CityCoordinates("Houston", 29.7604, -95.3698),
//			new CityCoordinates("Austin", 30.2672, -97.7431),
//			new CityCoordinates("San Francisco", 37.7749, -122.4194),
//			new CityCoordinates("Denver", 39.7392, -104.9903),
//			new CityCoordinates("Los Angeles", 34.0522, -118.2437),
//			new CityCoordinates("Chicago", 41.8781, -87.6298),
//			new CityCoordinates("New York", 40.7128, -74.0059),
//			new CityCoordinates("Dallas", 32.7767, -96.7970),
//			new CityCoordinates("Seatle", 47.6062, -122.3321)
//
//	));
//
//	public static void main(String[] args) {
//		Driver driver = new Driver();
//		ArrayList<CityCoordinates> names = new ArrayList<CityCoordinates>();
//		names.addAll(driver.initialCities);
//		driver.printShortestRoute(new NearestNeighbor().findShortestRoute(names));
//
//	}
//	private void printShortestRoute(Route shortestRoute) {
//		System.out.println("---------------------------------------------------------------------------");
//		System.out.println("Shoutest Route found so far: " + shortestRoute);
//		System.out.println("w/ total distance: " + shortestRoute.calculateTotalDistance());
//		System.out.println("---------------------------------------------------------------------------");
//
//    }
//
//}