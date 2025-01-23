package Day2.Level1_PP;
//finds the sum of numbers until the user enters 0 using while loop.
import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        System.out.print("Enter numbers (0 to stop): ");
        while (true) {
            double number = scanner.nextDouble();
            if (number == 0) {
                break;
            }
            total += number;
        }
        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}
