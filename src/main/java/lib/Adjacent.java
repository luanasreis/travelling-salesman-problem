package lib;

public class Adjacent {

    private final City city;
    private final int distance;

    // recebe no final da aresta e peso da aresta
    public Adjacente(City city, int distance) {
        this.city = city; //recebe o vertice
        this.distance = distance;// recebe o peso da aresta
    }

    public City getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }

}