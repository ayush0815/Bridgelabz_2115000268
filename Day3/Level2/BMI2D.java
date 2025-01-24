package Day3.Level2;

import java.util.Scanner;

public class BMI2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of persons:");
        int numPersons = sc.nextInt();

        double[][] personData = new double[numPersons][3]; // [height, weight, BMI]
        String[] status = new String[numPersons];

        // Input height and weight
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter height (in meters) for person " + (i + 1) + ":");
            personData[i][0] = sc.nextDouble();
            System.out.println("Enter weight (in kg) for person " + (i + 1) + ":");
            personData[i][1] = sc.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Invalid input. Please re-enter data for person " + (i + 1));
                i--; // Re-enter data for the same person
                continue;
            }

            // Calculate BMI
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            // Determine weight status
            if (personData[i][2] <= 18.4) {
                status[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                status[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nPerson Details:");
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + " - Height: " + personData[i][0] +
                               ", Weight: " + personData[i][1] + ", BMI: " + personData[i][2] +
                               ", Status: " + status[i]);
        }
    sc.close();
    }
}

