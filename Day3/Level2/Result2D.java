package Day3.Level2;

import java.util.Scanner;

public class Result2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int numStudents = sc.nextInt();

        double[][] marks = new double[numStudents][3]; // [Physics, Chemistry, Maths]
        double[] percentage = new double[numStudents];
        String[] grade = new String[numStudents];

        // Input marks for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            System.out.print("Physics: ");
            marks[i][0] = sc.nextDouble();

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextDouble();

            System.out.print("Maths: ");
            marks[i][2] = sc.nextDouble();

            // Validate marks
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid marks. Please re-enter for Student " + (i + 1));
                i--; // Re-enter for the same student
                continue;
            }

            // Calculate percentage
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

            // Assign grade
            if (percentage[i] >= 80) {
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] = "B";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
            } else if (percentage[i] >= 50) {
                grade[i] = "D";
            } else if (percentage[i] >= 40) {
                grade[i] = "E";
            } else {
                grade[i] = "R";
            }
        }

        // Display results
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + " - Physics: " + marks[i][0] + 
                               ", Chemistry: " + marks[i][1] + 
                               ", Maths: " + marks[i][2] + 
                               ", Percentage: " + percentage[i] + 
                               ", Grade: " + grade[i]);
        }
    sc.close();
    }
}

