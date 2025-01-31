import java.util.Scanner;
public class GCDandLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        scanner.close();

        int gcd = findGCD(num1, num2);
        int lcm = (num1 * num2) / gcd;

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    private static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}