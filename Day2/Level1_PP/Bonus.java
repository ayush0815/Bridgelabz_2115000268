package Day2.Level1_PP;
//find the bonus of employees based on their years of service.
// 5% bonus is number of service year>5
import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter your years of service: ");
        int years = scanner.nextInt();
        if (years > 5) {
            double bonus = salary * 0.05;
            System.out.println("Your bonus is: " + bonus);
        } else {
            System.out.println("No bonus for less than 6 years of service.");
        }
        scanner.close();
    }
}

