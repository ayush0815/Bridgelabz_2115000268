package Day3.Level2;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of persons:");
        int numPersons = sc.nextInt();

        double[] height = new double[numPersons];
        double[] weight = new double[numPersons];
        double[] bmi = new double[numPersons];
        String[] status = new String[numPersons];

        // Input height and weight for each person
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter height (in meters) for person " + (i + 1) + ":");
            height[i] = sc.nextDouble();
            System.out.println("Enter weight (in kg) for person " + (i + 1) + ":");
            weight[i] = sc.nextDouble();

            if (height[i] <= 0 || weight[i] <= 0) {
                System.out.println("Invalid input. Please re-enter data for person " + (i + 1));
                i--; // Decrement index to re-enter data
                continue;
            }

            // Calculate BMI
            bmi[i] = weight[i] / (height[i] * height[i]);

            // Determine weight status
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nPerson Details:");
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + " - Height: " + height[i] +
                               ", Weight: " + weight[i] + ", BMI: " + bmi[i] + ", Status: " + status[i]);
        }
    sc.close();
    }
}

