import java.util.Scanner;

class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        int quo = num1 / num2;
        int remain = num1 % num2;

        System.out.println("The Quotient is " + quo + " and Reminder is " + remain +
                           " of two numbers " + num1 + " and " + num2 + ".");
    }
}
