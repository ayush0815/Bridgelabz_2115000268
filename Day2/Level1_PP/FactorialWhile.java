package Day2.Level1_PP;

import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        if (n >= 0) {
            int factorial = 1, i = 1;
            while (i <= n) {
                factorial *= i;
                i++;
            }
            System.out.println("The factorial of " + n + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
        scanner.close();
    }
}
