package Day3.Level2;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        long number = sc.nextLong();

        int count = 0;
        long temp = number;

        // Count the digits in the number
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int index = 0;

        // Extract digits and store in array
        while (number > 0) {
            digits[index++] = (int) (number % 10);
            number /= 10;
        }

        // Display the reversed number
        System.out.println("Reversed Number:");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        sc.close();
    }
}

