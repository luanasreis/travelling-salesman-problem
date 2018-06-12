import lib.*;
import lib.filesHandle.AdjacentReader;
import lib.filesHandle.CitiesNameReader;
import lib.utils.ResultsHandler;
import lib.utils.RoutesHandler;
import lib.utils.TimeHandler;

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
        int solutionsTime = 10;
//        Integer[] aleatorySolution = travelingSalesman.buildAleatoryRoute(firstSolution);
//        ArrayList<Integer> circleWay = travelingSalesman.buildByCircleWay(false, firstSolution);
//
//        routesHandler.printRoute("First Solution", firstSolution, true, true);
//
//        routesHandler.printRoute("Creating route by swap neighbor", secondSolution, true, true);
//        routesHandler.printRoute("Creating route by choosing aleatory neighbor", aleatorySolution, true, true);
//        routesHandler.printRoute("Creating route by circle", circleWay, true, true);
        GRASP grasp = new GRASP(adjacentMatrix);

        ResultsHandler graspResults = new ResultsHandler("GRASP RESULTS", adjacentMatrix);
        for(int count = solutionsTime; count > 0; count--){
            graspResults.addAlgorithmResult(grasp.buildGRASP(0.7, firstSolution));
            graspResults.addTime(grasp.getTime().getLastTime());
        }

        graspResults.showBestResult();
        graspResults.showMediaTime();


//        routesHandler.printRoute("Creating route using GRASP", routeGrasp, true, true);


    }

}
