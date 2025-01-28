import java.util.Scanner;
public class PointDistanceAndLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        System.out.println("Euclidean Distance: " + distance);
        System.out.println("Equation of the line: y = " + lineEquation[0] + "*x + " + lineEquation[1]);
    }
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[] { slope, yIntercept };
    }
}
