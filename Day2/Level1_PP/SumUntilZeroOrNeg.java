package Day2.Level1_PP;
//find the sum until the user enters 0 or a negative number 
//using while loop and break statement

import java.util.Scanner;

public class SumUntilZeroOrNeg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        System.out.print("Enter numbers (0 or negative to stop): ");
        while (true) {
            double number = scanner.nextDouble();
            if (number <= 0) {
                break;
            }
            total += number;
        }
        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}

