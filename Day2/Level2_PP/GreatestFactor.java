package Day2.Level2_PP;

import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int greatestFactor = 1;

        for (int i = num - 1; i >= 1; i--) {
            if (num % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        System.out.println("The greatest factor of " + num + " (other than itself) is: " + greatestFactor);

        sc.close();
    }
}

