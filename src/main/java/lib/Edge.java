package lib;

public class Edge {

    private City A, B;
    private int distance;
    // recebe cidade A, cidade B e distancia da aresta
    public Edge(City A , City B, int distance) {
        this.A = A;
        this.B = B;
        this.distance = distance;
    }

    public Edge getA() {
        return A;
    }

    public void setA(Edge A) {
        this.A = A;
    }

    public Edge getB() {
        return B;
    }

    public void setB(Edge B) {
        this.B = B;
    }

    public int getDistance() {
        return distance;
    }

    public void setPeso(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return A.getNome() + " - " + B.getNome() + " - Distance: " + distance;
    }

}