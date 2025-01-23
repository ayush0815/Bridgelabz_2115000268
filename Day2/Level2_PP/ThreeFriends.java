package Day2.Level2_PP;

import java.util.Scanner;

public class ThreeFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height (in cm): ");
        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();

        System.out.print("Enter Akbar's age and height (in cm): ");
        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();

        System.out.print("Enter Anthony's age and height (in cm): ");
        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();

        // Find the youngest friend
        int youngest = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        if (youngest == ageAmar) {
            System.out.println("Youngest: Amar");
        } else if (youngest == ageAkbar) {
            System.out.println("Youngest: Akbar");
        } else {
            System.out.println("Youngest: Anthony");
        }

        // Find the tallest friend
        int tallest = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        if (tallest == heightAmar) {
            System.out.println("Tallest: Amar");
        } else if (tallest == heightAkbar) {
            System.out.println("Tallest: Akbar");
        } else {
            System.out.println("Tallest: Anthony");
        }

        sc.close();
    }
}

