package lib;

import java.util.ArrayList;

public class CityCoordinates {
    private int CityName;
    private double coordinatesX;
    private double coordinatesY;
    private CityCoordinates dad;
    private boolean visited;
//    private ArrayList<Adjacent> adjacent;

    public CityCoordinates(int CityName, double coordX, double coordY) {
        this.CityName = CityName;
        this.coordinatesX = coordX;
        this.coordinatesY = coordY;
        this.dad = null;
        this.visited = false;
    }

//    public CityCoordinates(int CityName, double coordX, double coordY) {
//        this(CityName, coordX,coordY);
//    }

//    public void setAdjacent(ArrayList<Adjacent> adj) {
//        this.adjacent = adj;
//    }
//
//    public Adjacent getAdjacent(int adj) {
//        return this.adjacent.get(adj);
//    }
//
//    public int getGrau() { //quant de vertices adj tem uma cidade (quantas cidades vizinhas)
//            return adjacent.size();
//        }

    public int getCityName() {
        return CityName;
    }

    public double getCoordinateX() {
        return coordinatesX;
    }

    public double getCoordinateY() {
        return coordinatesY;
    }

    public void setCoordinatesX(int coordX) {
        this.coordinatesX = coordX;
    }

    public void setCoordinatesY(int coordY) {
        this.coordinatesY = coordY;
    }

    public CityCoordinates getDad() {
        return dad;
    }

    public void setDad(CityCoordinates dad) {
        this.dad = dad;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
            this.visited = visited;
        }

    public double distance(CityCoordinates nextCityCoordinates) {
        return Math.sqrt(
                Math.pow(nextCityCoordinates.getCoordinateX() - this.getCoordinateX(), 2) +
                Math.pow(nextCityCoordinates.getCoordinateY() - this.getCoordinateY(), 2) * 1.0);
    }


}