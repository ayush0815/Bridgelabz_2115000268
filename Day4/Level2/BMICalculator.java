package L2;
import java.util.Scanner;

public class BMICalculator {
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100;
        return weight / (heightM * heightM);
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Normal weight";
        else if (bmi >= 25 && bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] statuses = new String[10];

        for (int i = 0; i < 10; i++) {
            data[i][0] = scanner.nextDouble();
            data[i][1] = scanner.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            statuses[i] = determineBMIStatus(data[i][2]);
        }

        System.out.println("Weight\tHeight\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", data[i][0], data[i][1], data[i][2], statuses[i]);
        }

        scanner.close();
    }
}
