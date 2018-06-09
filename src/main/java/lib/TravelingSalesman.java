package lib;
import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static java.lang.Boolean.FALSE;

public class TravelingSalesman {
    private int weightRoute = 0;
    private final int quantCities;
    private Integer[] route;
    private Double[][] adjacentMatrix;

    public TravelingSalesman(Double[][] adjacentMatrix) {
        this.adjacentMatrix = adjacentMatrix;
        this.quantCities = adjacentMatrix.length;
        this.route = new Integer[this.quantCities + 1];
        this.buildRoute();
    }

    private void buildRoute() {
        Boolean[] visited = new Boolean[this.quantCities];

        for(int i = 0; i < this.quantCities; i++) {
            visited[i] = false;
        }
        this.route[0] = 0;
        visited[0] = true;

        for(int i = 0; i < this.quantCities -1; i++) {
            double distance = Double.MAX_VALUE;
            int neighborSelected = 0;
            for(int j = 0; j < this.quantCities; j++) {
                if(!visited[j] && distance > adjacentMatrix[i][j]) {
                    neighborSelected = j;
                    distance = adjacentMatrix[i][j];
                }
            }

            this.route[i + 1] = neighborSelected;
            visited[neighborSelected] = true;
        }

        this.route[this.quantCities] = 0;
    }

    public Integer[] buildAleatoryRoute() {
        Random gerador = new Random();
        Integer[] route = Arrays.copyOf(this.getRoute(), this.getRoute().length);
        Boolean[] visited = new Boolean[this.quantCities];
        Neighboor[] neighbor = new Neighboor[this.quantCities-1];
        for(int i=0; i < this.quantCities; i++ ){
            visited[i] = false;
        }
        route[0] = 0;
        visited[0] = true;


        for(int i = 0; i < this.quantCities; i++) {
            int posicao = 0;
            for(int j = 0; j < this.quantCities; j++){
                if(!visited[j]) {
                    neighbor[posicao] = new Neighboor(j, adjacentMatrix[i][j]);
                    posicao++;
                }
            }
            if(posicao==0){ //caso não tenho mais vizinho algum
                route[i + 1] = 0;
            }else{
                int neighboorSelected = gerador.nextInt(this.quantCities)%posicao;
                route[i+1] = neighbor[neighboorSelected].getIndice();
                visited[neighbor[neighboorSelected].getIndice()] = true;
            }
        }
        return route;
    }

    public Integer[] buildSwapWay() {
        Integer[] tmpSolution = Arrays.copyOf(this.getRoute(), this.getRoute().length);
        double baseWeight = this.buildWeight(this.getRoute(), false, false);
        Integer[] bestSolution = Arrays.copyOf(this.getRoute(), this.getRoute().length);

        for(int position = 1; position < this.quantCities; position++) {
            tmpSolution = Arrays.copyOf(this.getRoute(), this.getRoute().length);
//            tmpSolution = bestSolution.clone(); //always getting the best solution
            for(int neighbor = position + 1; neighbor < this.quantCities - 1; neighbor++) {
                int tmpWay = tmpSolution[position];
                tmpSolution[position] = tmpSolution[neighbor];
                tmpSolution[neighbor] = tmpWay;
                double tmpWeight = this.buildWeight(tmpSolution, false, false);

                if(tmpWeight < baseWeight) {
                    baseWeight = tmpWeight;
                    bestSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
                }
            }
        }
        return bestSolution;
    }

    public ArrayList<Integer> buildByCircleWay(boolean printBuild) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Boolean[] visited = new Boolean[this.quantCities];

        for(int i = 0; i < this.quantCities; i++) {
            visited[i] = false;
        }
        visited[0] = true;
        visited[this.quantCities -1] = true;
        result.add(0);
        result.add(this.quantCities -1);

        for(int i = 0; i < this.quantCities -1; i++) {
            double distance = Double.MAX_VALUE;
            int neighborSelected = 0;
            for(int j = 0; j < this.quantCities; j++) {
                if(!visited[j] && distance > adjacentMatrix[i][j]) {
                    Double tmpBaseWeight = Double.MAX_VALUE;
                    ArrayList<Integer> tmpBaseRoute = new ArrayList<>();
                    for(int testRoute = 0; testRoute < result.size(); testRoute++){
                        ArrayList<Integer> tmpRoute = this.appendNode(result, testRoute, j);
                        Double tmpWeight = this.buildWeight(tmpRoute, false, false);
                        if(tmpWeight < tmpBaseWeight) {
                            tmpBaseWeight = tmpWeight;
                            tmpBaseRoute = new ArrayList<>(tmpRoute);
                        }
                    }
                    neighborSelected = j;
                    distance = adjacentMatrix[i][j];
                    result = new ArrayList<>(tmpBaseRoute);
                    this.buildWeight(result, printBuild, printBuild);
                    this.route[i + 1] = neighborSelected;
                    visited[neighborSelected] = true;
                }
            }

        }
        return result;
    }

    public void printRoute(Integer route[]) {
        StringBuilder result = new StringBuilder();
        for(int count = 0; count < route.length; count++) {
            result.append(route[count]).append(" -> ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 4));

        System.out.println(result);
    }

    public void printRoute(String algorithmName, ArrayList<Integer> route, boolean printDistance, boolean printWay) {
        System.out.println(algorithmName);
        this.buildWeight(route, printDistance, printWay);
        System.out.println("--------------------------------------");
    }

    public void printRoute(String algorithmName, Integer[] route, boolean printDistance, boolean printWay) {
        System.out.println(algorithmName);
        this.buildWeight(route, printDistance, printWay);
        System.out.println("--------------------------------------");
    }

    public Double buildWeight(Integer[] route, boolean printDistance, boolean printWay) {
        Double sumCount= 0.0;
        for (int count = 0; count < route.length -1; count ++) {
            sumCount += this.adjacentMatrix[route[count]][route[count + 1]];
        }

        if (printDistance) {
            System.out.println("Distância total: "  + sumCount);
        }

        if(printWay) {
            this.printRoute(route);
        }

        return sumCount;
    }

    public Double buildWeight(ArrayList<Integer> route, boolean printDistance, boolean printWay) {
        double weight = 0.0;
        int roundTrip;
        for(int count = 0; count < route.size(); count++) {
            if((count+1) == route.size()) {
                roundTrip = count -1;
            } else {
                roundTrip = count+1;
            }
            weight += this.adjacentMatrix[route.get(count)][route.get(roundTrip)];
        }
        if(printDistance){
            System.out.println("Distância Total: " + weight);
        }
        if(printWay) {
            StringBuilder result = new StringBuilder();
            for(int count = 0; count < route.size(); count++) {
                result.append(route.get(count)).append(" -> ");
            }
            result.append(route.get(0));
            System.out.println(result);
        }
        return weight;
    }

    private ArrayList<Integer> appendNode(ArrayList<Integer> route, int position, Integer node) {
        ArrayList<Integer> tmpRoute = new ArrayList<>(route);
        if(position == 0){
            position += 1;
        }
        if( position == route.size()) {
            position -= 1;
        }
        tmpRoute.add(position, node);
        return tmpRoute;
    }

    public Double buildWeight(boolean printDistance) {
        return this.buildWeight(this.getRoute(), printDistance, false);
    }

    public Integer[] getRoute(){ return this.route; }


}
