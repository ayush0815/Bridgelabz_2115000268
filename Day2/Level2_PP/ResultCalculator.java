package Day2.Level2_PP;

import java.util.Scanner;

public class ResultCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks in Physics: ");
        int phy = sc.nextInt();
        System.out.print("Enter marks in Chemistry: ");
        int chem = sc.nextInt();
        System.out.print("Enter marks in Maths: ");
        int maths = sc.nextInt();

        int total = phy + chem + maths;
        double percent = total / 3.0;

        System.out.println("Percentage: " + percent + "%");

        if (percent >= 80) {
            System.out.println("Grade: A (Level 4, above agency-normalized standards)");
        } else if (percent >= 70) {
            System.out.println("Grade: B (Level 3, at agency-normalized standards)");
        } else if (percent >= 60) {
            System.out.println("Grade: C (Level 2, below, but approaching agency-normalized standards)");
        } else if (percent >= 50) {
            System.out.println("Grade: D (Level 1, well below agency-normalized standards)");
        } else if (percent >= 40) {
            System.out.println("Grade: E (Level 1-, too below agency-normalized standards)");
        } else {
            System.out.println("Grade: R (Remedial standards)");
        }

        sc.close();
    }
}

