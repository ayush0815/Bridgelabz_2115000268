package Day2.Level2_PP;

import java.util.Scanner;

public class PowerOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int num = sc.nextInt();
        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        int res = 1;

        for (int i = 1; i <= power; i++) {
            res *= num;
        }

        System.out.println(num + " raised to the power of " + power + " is: " + res);

        sc.close();
    }
}
