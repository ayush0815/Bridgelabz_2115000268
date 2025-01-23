package Day2.Level3_PP;
import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;

        while (number != 0) {
            int remainder = number % 10; // Get the last digit
            sum += remainder;            // Add the digit to the sum
            number /= 10;                // Remove the last digit
        }

        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad number.");
        }

        scanner.close();
    }
}
