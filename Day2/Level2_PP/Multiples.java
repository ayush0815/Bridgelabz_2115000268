package Day2.Level2_PP;

import java.util.Scanner;

public class Multiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Multiples of " + num + " below 100 are:");
        for (int i = 1; i < 100; i++) {
            if (i % num == 0) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }
}

