package lib;

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

    public void buildRoute() {
        Boolean[] visited = new Boolean[this.quantCities];

        for(int i = 0; i < this.quantCities -1; i++) {
            visited[i] = false;
        }
        this.route[0] = 0;
        visited[0] = true;

        for(int i = 0; i < this.quantCities -1; i++) {
            double distance = Double.MAX_VALUE;
            int neighborSelected = 0;
            for(int j = 0; j < this.quantCities -1; j++) {
                if(!visited[j] && distance > adjacentMatrix[i][j]) {
                    neighborSelected = j;
                    distance = adjacentMatrix[i][j];
                }
            }

            this.route[i + 1] = neighborSelected;
            visited[neighborSelected] = true;
        }

        this.route[this.quantCities -1] = 0;
    }

    public Integer[] buildSwapWay() {
        Integer[] tmpSolution = this.getRoute();
        double baseWeight = this.buildWeight(this.getRoute(), false, false);
        Integer[] bestSolution = new Integer[0];
        for(int position = 1; position < this.quantCities; position++) {
            for(int neighbor = position + 1; neighbor < this.quantCities - 1; neighbor++) {
                int tmpWay = tmpSolution[position];
                tmpSolution[position] = tmpSolution[neighbor];
                tmpSolution[neighbor] = tmpWay;
                double tmpWeight = this.buildWeight(tmpSolution, false, false);

                if(tmpWeight < baseWeight) {
                    baseWeight = tmpWeight;
                    bestSolution = tmpSolution;
                }
            }
        }

        if (bestSolution.length > 0) {
            return bestSolution;
        }
        return this.getRoute();
    }

    public void printRoute(Integer route[]) {
        StringBuilder result = new StringBuilder();
        for(int count = 0; count < route.length -1; count++) {
            result.append(route[count]).append(" -> ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 4));

        System.out.println(result);
    }

    public Double buildWeight(Integer[] route, boolean printDistance, boolean printWay) {
        Double sumCount= 0.0;
        for (int count = 0; count < this.quantCities -1; count ++) {
            sumCount += this.adjacentMatrix[route[count]][route[count + 1]];
        }

        if (printDistance) {
            System.out.println("Distântia total: "  + sumCount);
        }

        if(printWay) {
            this.printRoute(route);
        }

        return sumCount;
    }

    public Double buildWeight(boolean printDistance) {
        return this.buildWeight(this.getRoute(), printDistance, false);
    }

    public Integer[] getRoute(){ return this.route; }


}
