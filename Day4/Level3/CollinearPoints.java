public class CollinearPoints {
    public static boolean CollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double) (y2 - y1) / (x2 - x1);
        double slopeBC = (double) (y3 - y2) / (x3 - x2);
        double slopeAC = (double) (y3 - y1) / (x3 - x1);
        return (slopeAB == slopeBC && slopeBC == slopeAC);
    }
    public static boolean CollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return (area == 0);
    }
    public static void main(String[] args) {
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;
        if (CollinearSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using slope formula.");
        } else {
            System.out.println("The points are not collinear using slope formula.");
        }
        if (CollinearArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using area of triangle formula.");
        } else {
            System.out.println("The points are not collinear using area of triangle formula.");
        }
    }
}
