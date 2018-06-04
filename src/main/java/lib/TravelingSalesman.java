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
        this.route = new Integer[this.quantCities];
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

    @Override
    public String toString() {
        String result = "";
        for(int count = 0; count < this.route.length -1; count++) {
            result += this.route[count] + " -> ";
        }
        return result;
    }
}
