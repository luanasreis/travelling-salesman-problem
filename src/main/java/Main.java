import lib.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        // Vai ler o arquivo original e separar em tour e cidades.
//        FileInputReader fileInputReader = new FileInputReader();
//        ArrayList<Integer> tour = fileInputReader.getTour();
//        ArrayList<CityCoordinates> names = fileInputReader.getCities();
        // This line will write at a file data/adjacent/adjacent.txt an adjacent matrix of data
//        WriteAdjacentFile createAdjacentFile = new WriteAdjacentFile(names, "");
        // Vai ler o arquivo de nomes encontrado em data/names
        CitiesNameReader names = new CitiesNameReader();
        //Vai ler o arquivo de adjacentes encontrado em data/adjacents
        AdjacentReader adjacents = new AdjacentReader(names);
        ArrayList<City> cities = adjacents.getCities();
        System.out.println(cities.get(cities.size() -1).getAdjacents());
        Double[][] adjacentMatrix = adjacents.createFullAdjacentMatrix(true);

        TravelingSalesman travelingSalesman = new TravelingSalesman(adjacentMatrix);
        travelingSalesman.buildWeight(travelingSalesman.getRoute(), true, true);
        Integer[] secondSolution = travelingSalesman.buildSwapWay();
        travelingSalesman.buildWeight(secondSolution, true, true);
    }
}
