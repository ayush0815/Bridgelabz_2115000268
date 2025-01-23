package Day2.Level1_PP;

import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting value for countdown: ");
        int counter = scanner.nextInt();
        for (int i = counter; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!!");
        scanner.close();
    }
}

