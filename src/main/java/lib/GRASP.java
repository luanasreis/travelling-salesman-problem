package lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GRASP {
    private final Double[][] adjacentMatrix;

    public GRASP(Double[][] matrix) {
        this.adjacentMatrix = Arrays.copyOf(matrix, matrix.length);
    }


    public Integer[] buildGRASP(double alfa, Integer[] route) {
        Integer[] graspRoute = Arrays.copyOf(route, route.length);
        int numberOfCities = graspRoute.length -1;
        Random gerador = new Random();
        Boolean[] visited = new Boolean[numberOfCities];
        ArrayList<Neighboor> LC = new ArrayList<>();
        ArrayList<Neighboor> LCR = new ArrayList<>();
        double menorDistancia;
        double maiorDistancia;
        double filter;
        int selectedIndice;
        int cidadeAtual = 0;

        for(int i=0; i < numberOfCities; i++ ){
            visited[i] = false;
        }
        route[0] = 0;
        visited[0] = true;

        int i = 0;
        while(true) {
            LC = new ArrayList<>();
            for(int j = 0; j < numberOfCities; j++){
                if(!visited[j]) {
                    LC.add(new Neighboor(j, adjacentMatrix[cidadeAtual][j]));
                }
            }

            if(i+1 == route.length){ //caso não tenho mais vizinho algum
                route[i + 1] = 0;
                break;
            } else{
                Collections.sort(LC);
                menorDistancia = LC.get(0).getValor();
                maiorDistancia = LC.get(LC.size()-1).getValor();
                filter = alfa * (maiorDistancia - menorDistancia);
                LCR = new ArrayList<>();
                System.out.println(filter);
                for(int count =0 ; count < LC.size(); count++){
                    if(LC.get(count).getValor() <= filter) {
                        System.out.println(LC.get(count).getValor());
                        LCR.add(LC.get(count));
                    }
                }

                if(!LCR.isEmpty()) {
                    int selectedCandidate = gerador.nextInt(LCR.size());
                    System.out.println(selectedCandidate);
                    selectedIndice = LCR.get(selectedCandidate).getIndice();
                    route[i + 1] = selectedIndice;
                    cidadeAtual = selectedIndice;
                    visited[selectedIndice] = true;
                }
            }
        }

        return route;
    }
}
