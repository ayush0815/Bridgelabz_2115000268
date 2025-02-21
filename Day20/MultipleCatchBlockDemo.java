import java.util.InputMismatchException;
import java.util.Scanner;
public class MultipleCatchBlockDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer[] numbers = {10, 20, 30, 40, 50}; // Change to null to trigger NullPointerException
            System.out.print("Enter index to retrieve value");
            int index = scanner.nextInt();

            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter an integer.");
        } finally {
            scanner.close();
        }
    }
}
