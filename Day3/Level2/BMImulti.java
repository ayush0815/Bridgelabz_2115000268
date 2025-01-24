package Day3.Level2;

import java.util.Scanner;

public class BMImulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of persons
        System.out.println("Enter the number of persons:");
        int number = sc.nextInt();

        // Create multi-dimensional array for weight, height, and BMI
        double[][] personData = new double[number][3]; // Columns: [0] -> Weight, [1] -> Height, [2] -> BMI
        String[] weightStatus = new String[number];

        // Input weight and height for each person
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");

            // Input weight
            do {
                System.out.print("Weight (kg): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Weight must be positive. Please re-enter.");
                }
            } while (personData[i][0] <= 0);

            // Input height
            do {
                System.out.print("Height (m): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Height must be positive. Please re-enter.");
                }
            } while (personData[i][1] <= 0);

            // Calculate BMI
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            // Determine weight status
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the details of each person
        System.out.println("\nDetails of each person:");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Person", "Weight (kg)", "Height (m)", "BMI", "Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s\n", 
                              (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

    sc.close();
    }
}

