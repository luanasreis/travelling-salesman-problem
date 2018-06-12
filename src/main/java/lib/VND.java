package lib;

import lib.utils.RoutesHandler;
import lib.utils.TimeHandler;

import java.util.Arrays;
import java.util.Random;

public class VND {
    private RoutesHandler routesHandler;
    public VND(Double matrix[][]) {
        this.routesHandler = new RoutesHandler(matrix);

    }

    public Integer[] buildVND(Integer[] route, boolean showTime) {
        Integer[] tmpSwapRoute = Arrays.copyOf(route, route.length);
        TimeHandler timeHandler = new TimeHandler();
        timeHandler.startTime();
        Integer[] bestSolution;
        double tmpDistance = 0.0;
        double bestDistance;
        // considera o algoritmo passado como o valor base de distancia inicial;
        tmpDistance = this.routesHandler.buildWeight(tmpSwapRoute, false, false);

        int test = 0;

        while(true){
            bestSolution = this.findBestSolution(tmpSwapRoute, tmpDistance);
            bestDistance = this.routesHandler.buildWeight(bestSolution, false, false);
            tmpSwapRoute = this.buildInsertionSwapWay(bestSolution, false);
            tmpDistance = this.routesHandler.buildWeight(tmpSwapRoute, false, false);

            if(tmpDistance < bestDistance) {
                bestSolution = Arrays.copyOf(tmpSwapRoute, tmpSwapRoute.length);
            }
            else {
                break;
            }
        }

        timeHandler.stopTime();
        if(showTime) {
            System.out.println("VND Time: " + timeHandler.getLastTime());
        }

        return bestSolution;
    }

    private Integer[] findBestSolution(Integer[] route, double bestDistance) {
        Integer[] tmpSwapRoute = Arrays.copyOf(route, route.length);
        double tmpDistance = Double.MAX_VALUE;
        while(tmpDistance < bestDistance) {
            tmpSwapRoute = this.buildSwapWay(tmpSwapRoute);
            tmpDistance = this.routesHandler.buildWeight(tmpSwapRoute, false, false);
        }

        return Arrays.copyOf(tmpSwapRoute, tmpSwapRoute.length);
    }

    public Integer[] buildSwapWay(Integer[] route) {
        Integer[] tmpSolution = Arrays.copyOf(route, route.length);
        double baseWeight = this.routesHandler.buildWeight(tmpSolution, false, false);
        Integer[] bestSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);

        for(int position = 1; position < route.length-1; position++) {
            tmpSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
//            tmpSolution = Arrays.copyOf(bestSolution, bestSolution.length); //always getting the best solution
            for(int neighbor = position + 1; neighbor < route.length - 1; neighbor++) {
                int tmpWay = tmpSolution[position];
                tmpSolution[position] = tmpSolution[neighbor];
                tmpSolution[neighbor] = tmpWay;
                double tmpWeight = this.routesHandler.buildWeight(tmpSolution, false, false);

                if(tmpWeight < baseWeight) {
                    baseWeight = tmpWeight;
                    bestSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
                }
            }
        }
        return Arrays.copyOf(bestSolution, bestSolution.length);
    }

    public Integer[] buildInsertionSwapWay(Integer[] route, boolean printWay) {
        Integer[] tmpSolution = Arrays.copyOf(route, route.length);
        double baseWeight = this.routesHandler.buildWeight(tmpSolution, false, false);
        Integer[] bestSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
        Random gerador = new Random();

        int insert = gerador.nextInt(route.length -1);

        insert = insert == 0 ? 1 : insert;

        if(printWay) {
            System.out.println("Insertion value: " + insert);
        }

        for(int position = 1; position < route.length -1 ; position++) {
            tmpSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
            for(int neighbor = position + 1; neighbor < route.length - 1; neighbor++) {
                if(neighbor == insert) {
                    ++neighbor;
                }
                int swapPosition = tmpSolution[insert];
                tmpSolution[insert] = tmpSolution[neighbor];
                tmpSolution[neighbor] = swapPosition;
                double tmpWeight = this.routesHandler.buildWeight(tmpSolution, false, printWay);

                if(tmpWeight < baseWeight) {
                    baseWeight = tmpWeight;
                    bestSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
                }
            }
        }
        return Arrays.copyOf(bestSolution, bestSolution.length);
    }
}
