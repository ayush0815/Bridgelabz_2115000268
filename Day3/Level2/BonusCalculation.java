package Day3.Level2;

import java.util.Scanner;

public class BonusCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary for employee " + (i + 1) + ":");
            double sal = sc.nextDouble();
            System.out.println("Enter years of service for employee " + (i + 1) + ":");
            double yrs = sc.nextDouble();

            if (sal <= 0 || yrs < 0) {
                System.out.println("Invalid input. Please re-enter data for employee " + (i + 1));
                i--; // Decrement index to re-enter data
                continue;
            }

            salary[i] = sal;
            yearsOfService[i] = yrs;

            // Calculate bonus
            if (yrs > 5) {
                bonus[i] = sal * 0.05;
            } else {
                bonus[i] = sal * 0.02;
            }

            newSalary[i] = sal + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += sal;
            totalNewSalary += newSalary[i];
        }

        // Print results
        System.out.println("\nEmployee Details:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + " - Old Salary: " + salary[i] +
                               ", Bonus: " + bonus[i] + ", New Salary: " + newSalary[i]);
        }
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        sc.close();
    }
}
