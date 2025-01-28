import java.util.Scanner;
public class AthleteRun {
    public static int calculateRounds(int side1, int side2, int side3) {
        int perimeter = side1 + side2 + side3;
        return (int) Math.ceil(5000.0 / perimeter);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first side of the triangle (in meters): ");
        int side1 = scanner.nextInt();
        System.out.print("Enter the second side of the triangle (in meters): ");
        int side2 = scanner.nextInt();
        System.out.print("Enter the third side of the triangle (in meters): ");
        int side3 = scanner.nextInt();       
        int rounds = calculateRounds(side1, side2, side3);
        System.out.println("The athlete needs to complete " + rounds + " rounds to run 5 km.");
        scanner.close();
    }
}
