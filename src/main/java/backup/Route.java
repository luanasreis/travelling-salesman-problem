//package backup;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Route {
//	private ArrayList<CityCoordinates> names = new ArrayList<CityCoordinates>();
//	public Route(ArrayList<CityCoordinates> names) { this.names.addAll(names); }
//	public ArrayList<CityCoordinates> getCities() { return names; }
//	public int calculateTotalDistance() {
//		int citiesSize = this.getCities().size();
//		return (int) (this.getCities().stream().mapToDouble(x -> {
//			int cityIndex = this.getCities().indexOf(x);
//			double returnValue = 0;
//			if(cityIndex < citiesSize - 1) returnValue = x.measureDistance(this.getCities().get(cityIndex + 1));
//			return returnValue;
//		}).sum() + this.getCities().get(citiesSize - 1).measureDistance(this.getCities().get(0)));
//	}
//	public String toString() { return Arrays.toString(names.toArray()); }
//
//}
//
//
//
//
