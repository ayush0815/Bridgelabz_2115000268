package Day2.Level3_PP;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int count = 0;

        while (number != 0) {
            number /= 10; // Remove the last digit
            count++;      // Increment the digit count
        }

        System.out.println("The number of digits is: " + count);

        scanner.close();
    }
}
