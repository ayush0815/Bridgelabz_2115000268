import java.util.Scanner;
public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();
        scanner.close();

        System.out.println("Fibonacci Sequence:");
        generateFibonacci(terms);
    }

    private static void generateFibonacci(int terms) {
        int firstTerm = 0, secondTerm = 1;
        System.out.print(firstTerm + " " + secondTerm + " ");

        for (int i = 2; i < terms; ++i) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(nextTerm + " ");
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
