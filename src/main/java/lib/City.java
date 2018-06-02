package lib;

public class City{
    private final int CityName;
    double coordinatesX;
    double coordinatesY;
    private City dad;
    private boolean visited;

    public City(int CityName, double coordX, double coordY) {
        this.CityName = CityName;
        this.coordinatesX = coordX;
        this.coordinatesY = coordY;
        this.dad = null;
        this.visited = false;
    }

        public City(int CityName, double coordX, double coordY) {
            this(CityName, coordX,coordY);
        }


        public int getCityName() {
            return CityName;
        }

        public int getCoordinateX() {
            return coordinatesX;
        }

        public int getCoordinateY() {
            return coordinatesY;
        }

        public void setCoordinatesX(int coordX) {
            this.coordinatesX = coordX;
        }

        public void setCoordinatesY(int coordY) {
            this.coordinatesY = coordY;
        }

        public City getDad() {
            return dad;
        }

        public void setDad(City dad) {
            this.dad = dad;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }


}