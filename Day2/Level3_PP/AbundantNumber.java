package Day2.Level3_PP;
import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i; // Add the divisor to the sum
            }
        }

        if (sum > num) {
            System.out.println(num + " is an Abundant number.");
        } else {
            System.out.println(num + " is not an Abundant number.");
        }

        sc.close();
    }
}
