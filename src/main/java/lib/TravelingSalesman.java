package lib;
import lib.utils.RoutesHandler;
import lib.utils.TimeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.*;

public class TravelingSalesman {
    private final int quantCities;
    private Integer[] route;
    private Double[][] adjacentMatrix;
    private RoutesHandler routesHandler;
    private TimeHandler timeHandler;

    public TravelingSalesman(Double[][] adjacentMatrix) {
        this.adjacentMatrix = Arrays.copyOf(adjacentMatrix, adjacentMatrix.length);
        this.quantCities = adjacentMatrix.length;
        this.routesHandler = new RoutesHandler(this.adjacentMatrix);
        timeHandler = new TimeHandler();
    }

    public Integer[] buildRoute() {
        timeHandler.startTime();
        Boolean[] visited = new Boolean[this.quantCities];
        Integer[] route = new Integer[this.quantCities + 1];

        for(int i = 0; i < this.quantCities; i++) {
            visited[i] = false;
        }

        route[0] = 0;
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

            route[i + 1] = neighborSelected;
            visited[neighborSelected] = true;
        }

        route[this.quantCities] = 0;
        timeHandler.stopTime();
        return route;

    }

    public Integer[] buildAleatoryRoute(Integer[] route) {
        timeHandler.startTime();
        Random gerador = new Random();
        Integer[] aleatoryRoute = Arrays.copyOf(route, route.length);
        Boolean[] visited = new Boolean[this.quantCities];
        Neighboor[] neighbor = new Neighboor[this.quantCities-1];
        for(int i=0; i < this.quantCities; i++ ){
            visited[i] = false;
        }
        aleatoryRoute[0] = 0;
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
                aleatoryRoute[i + 1] = 0;
            }else{
                int neighboorSelected = gerador.nextInt(this.quantCities)%posicao;
                aleatoryRoute[i+1] = neighbor[neighboorSelected].getIndice();
                visited[neighbor[neighboorSelected].getIndice()] = true;
            }
        }
        timeHandler.stopTime();
        return aleatoryRoute;

    }

    public ArrayList<Integer> buildByCircleWay(boolean printBuild, Integer[] route) {
        timeHandler.startTime();
        ArrayList<Integer> circleWay = new ArrayList<Integer>();
        Integer[] localRoute = Arrays.copyOf(route, route.length);

        Boolean[] visited = new Boolean[this.quantCities];

        for(int i = 0; i < this.quantCities; i++) {
            visited[i] = false;
        }
        visited[0] = true;
        visited[this.quantCities -1] = true;
        circleWay.add(0);
        circleWay.add(this.quantCities -1);

        for(int i = 0; i < this.quantCities -1; i++) {
            double distance = Double.MAX_VALUE;
            int neighborSelected;

            for(int j = 0; j < this.quantCities; j++) {
                if(!visited[j] && distance > adjacentMatrix[i][j]) {
                    Double tmpBaseWeight = Double.MAX_VALUE;
                    ArrayList<Integer> tmpBaseRoute = new ArrayList<>();
                    for(int testRoute = 0; testRoute < circleWay.size(); testRoute++){
                        ArrayList<Integer> tmpRoute = this.routesHandler.appendNode(circleWay, testRoute, j);
                        Double tmpWeight = this.routesHandler.buildWeight(tmpRoute, false, false);
                        if(tmpWeight < tmpBaseWeight) {
                            tmpBaseWeight = tmpWeight;
                            tmpBaseRoute = new ArrayList<>(tmpRoute);
                        }
                    }
                    neighborSelected = j;
                    distance = adjacentMatrix[i][j];
                    circleWay = new ArrayList<>(tmpBaseRoute);
                    this.routesHandler.buildWeight(circleWay, printBuild, printBuild);
                    localRoute[i + 1] = neighborSelected;
                    visited[neighborSelected] = true;
                }
            }

        }
        timeHandler.stopTime();
        return circleWay;

    }

    public TimeHandler getTime() {
        return this.timeHandler;
    }
}


