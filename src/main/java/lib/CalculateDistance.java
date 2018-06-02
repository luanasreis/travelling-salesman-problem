package lib;

public class CalculateDistance {

    // Function to calculate distance
    static double distance(double coodXv1, double coordYv1, double coordXv2, coordYv2) {
        // Calculating distance
        return Math.sqrt(Math.pow(coordXv2 - coodXv1, 2) +
                Math.pow(coordYv2 - coodYv1, 2) * 1.0);
    }

}