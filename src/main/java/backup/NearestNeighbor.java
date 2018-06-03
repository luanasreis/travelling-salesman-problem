//package backup;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class NearestNeighbor {
//	public Route findShortestRoute(ArrayList<CityCoordinates> names) {
//		ArrayList<CityCoordinates> shortestRouteCities = new ArrayList<CityCoordinates>(names.size());
//		System.out.println("---------------------------------------------------------------------------");
//		System.out.println("Initial Route        => " + Arrays.toString(names.toArray()));
//		System.out.println("w/ total distance: " + new Route(names).calculateTotalDistance());
//		System.out.println("---------------------------------------------------------------------------");
//		CityCoordinates city = names.get((int)(names.size() * Math.random()));
//		updateRoutes(shortestRouteCities, names, city);
//		while (names.size() >= 1) {
//			city = getNextCity(names, city);
//			updateRoutes(shortestRouteCities, names, city);
//		}
//
//		return new Route(shortestRouteCities);
//	}
//	private void updateRoutes(ArrayList<CityCoordinates> shortestRouteCities, ArrayList<CityCoordinates> names, CityCoordinates city) {
//		shortestRouteCities.add(city);
//		names.remove(city);
//		System.out.println("Cities In Shortest Route ==> " + Arrays.toString(shortestRouteCities.toArray()));
//		System.out.println("Remaining Cities         ==> " + Arrays.toString(names.toArray())+ "\n");
//	}
//	private CityCoordinates getNextCity(ArrayList<CityCoordinates> names, CityCoordinates city) {
////		return names.stream().min((city1, city2) -> {
////			int flag = 0;
////			if(city1.measureDistance(city) < city2.measureDistance(city)) flag = -1;
////			else if(city1.measureDistance(city) > city2.measureDistance(city)) flag = 1;
////			return flag;
////		}).get();
////
////	}
//}
