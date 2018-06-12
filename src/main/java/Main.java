import lib.*;
import lib.filesHandle.AdjacentReader;
import lib.filesHandle.CitiesNameReader;
import lib.utils.RoutesHandler;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        CitiesNameReader names = new CitiesNameReader();
        AdjacentReader adjacents = new AdjacentReader(names);
        Integer[] firstSolution;

        Double[][] adjacentMatrix = adjacents.createFullAdjacentMatrix(false);
        RoutesHandler routesHandler = new RoutesHandler(adjacentMatrix);
        TravelingSalesman travelingSalesman = new TravelingSalesman(adjacentMatrix);
        VND vnd = new VND(adjacentMatrix);
        firstSolution = travelingSalesman.buildRoute();
//        Integer[] secondSolution = travelingSalesman.buildSwapWay(firstSolution);
//        Integer[] aleatorySolution = travelingSalesman.buildAleatoryRoute(firstSolution);
//        ArrayList<Integer> circleWay = travelingSalesman.buildByCircleWay(false, firstSolution);
        Integer[] insertionSolution = vnd.buildInsertionSwapWay(firstSolution, false);

//        routesHandler.printRoute("First Solution", firstSolution, true, true);

//        routesHandler.printRoute("Creating route by swap neighbor", secondSolution, true, true);
//        routesHandler.printRoute("Creating route by choosing aleatory neighbor", aleatorySolution, true, true);
//        routesHandler.printRoute("Creating route by circle", circleWay, true, true);
//        routesHandler.printRoute("Creating route inserting fix value", insertionSolution, true, true);
        Integer[] vndSolution = vnd.buildVND(firstSolution, true);
        routesHandler.printRoute("Solução por VND", vndSolution, true, true);
// GRASP grasp = new GRASP(adjacentMatrix);
//        Integer[] routeGrasp = grasp.buildGRASP(0.5, firstSolution);
//        routesHandler.printRoute("Creating route using GRASP", routeGrasp, true, true);
//        Integer[] graspSolution = travelingSalesman.buildGRASP(0.5);
//        travelingSalesman.printRoute("Creating GRASP", graspSolution, true, true);

    }

}
