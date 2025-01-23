package Day2.Level3_PP;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double first = sc.nextDouble();

        System.out.print("Enter second number: ");
        double second = sc.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }

        sc.close();
    }
}
