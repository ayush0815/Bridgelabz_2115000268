package L2;
import java.util.Scanner;
public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        return (year >= 1582) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
   }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
   scanner.close(); }
}
