package L2;
import java.util.Scanner;

public class NumberAnalyzer {
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print(num + " is positive and ");
                if (isEven(num)) System.out.println("even.");
                else System.out.println("odd.");
            } else {
                System.out.println(num + " is negative.");
            }
        }
        int comparison = compare(numbers[0], numbers[4]);
        if (comparison == 1) System.out.println("First number is greater than the last number.");
        else if (comparison == 0) System.out.println("First and last numbers are equal.");
        else System.out.println("First number is less than the last number.");
        scanner.close();
    }
}
