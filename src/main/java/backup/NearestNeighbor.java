//package backup;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class NearestNeighbor {
//	public Route findShortestRoute(ArrayList<City> cities) {
//		ArrayList<City> shortestRouteCities = new ArrayList<City>(cities.size());
//		System.out.println("---------------------------------------------------------------------------");
//		System.out.println("Initial Route        => " + Arrays.toString(cities.toArray()));
//		System.out.println("w/ total distance: " + new Route(cities).calculateTotalDistance());
//		System.out.println("---------------------------------------------------------------------------");
//		City city = cities.get((int)(cities.size() * Math.random()));
//		updateRoutes(shortestRouteCities, cities, city);
//		while (cities.size() >= 1) {
//			city = getNextCity(cities, city);
//			updateRoutes(shortestRouteCities, cities, city);
//		}
//
//		return new Route(shortestRouteCities);
//	}
//	private void updateRoutes(ArrayList<City> shortestRouteCities, ArrayList<City> cities, City city) {
//		shortestRouteCities.add(city);
//		cities.remove(city);
//		System.out.println("Cities In Shortest Route ==> " + Arrays.toString(shortestRouteCities.toArray()));
//		System.out.println("Remaining Cities         ==> " + Arrays.toString(cities.toArray())+ "\n");
//	}
//	private City getNextCity(ArrayList<City> cities, City city) {
//		return cities.stream().min((city1, city2) -> {
//			int flag = 0;
//			if(city1.measureDistance(city) < city2.measureDistance(city)) flag = -1;
//			else if(city1.measureDistance(city) > city2.measureDistance(city)) flag = 1;
//			return flag;
//		}).get();
//
//	}
//}
