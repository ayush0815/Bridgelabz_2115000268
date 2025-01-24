package Day3.Level2;

import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        long number = sc.nextLong();

        int[] digits = new int[10];
        int index = 0;

        // Extract digits
        while (number > 0) {
            digits[index++] = (int) (number % 10);
            number /= 10;
        }

        // Find largest and second largest
        int largest = 0, secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);
        sc.close();
    }
}

