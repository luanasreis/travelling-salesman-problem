package lib;
import java.io.*;
import java.util.ArrayList;

public class AdjacentReader {
    private ArrayList<City> neighbors;
    private ArrayList<City> cities;
    private final String dataFilesPath = "./src/main/java/data/adjacent/adjacent15.txt";

    public AdjacentReader(CitiesNameReader names) {
        this.neighbors = new ArrayList<City>();
        File file = new File(this.dataFilesPath);
        FileReader inputStream = null;
        this.cities = new ArrayList<City>();
        try {
                inputStream = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(inputStream);
                bufferedReader.lines().forEach( line -> {
                    String[] fileData = line.split(" ");

                    City initialCity = new City(names.getAleatoryName(), 0.0);
                    for(String weight : fileData) {
                        StringBuilder str = new StringBuilder(weight);
                        str.setCharAt(weight.indexOf(','), '.');
                        City city = new City(names.getAleatoryName(), Double.parseDouble(str.toString()));
                        initialCity.addAdjacent(city);
                    }
                    cities.add(initialCity);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<City> getCities() { return this.cities; }

}
