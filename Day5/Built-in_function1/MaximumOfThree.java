import java.util.Scanner;
public class MaximumOfThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = getInput(scanner, "Enter the first number: ");
        int num2 = getInput(scanner, "Enter the second number: ");
        int num3 = getInput(scanner, "Enter the third number: ");
        scanner.close();

        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + max);
    }

    private static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}