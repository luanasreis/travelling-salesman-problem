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
        Double[][] adjacentMatrix = adjacents.createFullAdjacentMatrix(false);

        TravelingSalesman travelingSalesman = new TravelingSalesman(adjacentMatrix);
        System.out.println("Travelling Salesman");
        travelingSalesman.buildWeight(travelingSalesman.getRoute(), true, true);
        System.out.println("--------------------------");
        System.out.println("\n");

        Integer[] secondSolution = travelingSalesman.buildSwapWay();
        Integer[] aleatorySolution = travelingSalesman.buildAleatoryRoute();
        ArrayList<Integer> circleWay = travelingSalesman.buildByCircleWay(false);

        travelingSalesman.printRoute("Creating route by swap neighbor", secondSolution, true, true);
        travelingSalesman.printRoute("Creating route by choosing aleatory neighbor", aleatorySolution, true, true);
        travelingSalesman.printRoute("Creating route by circle", circleWay, true, true);
    }
}
