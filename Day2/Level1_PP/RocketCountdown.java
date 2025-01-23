package Day2.Level1_PP;
// Print countdown for Rocket launch using while loop.
import java.util.Scanner;

public class RocketCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting value for countdown: ");
        int counter = scanner.nextInt();
        while (counter > 0) {
            System.out.println(counter);
            counter--;
        }
        System.out.println("Liftoff Naarmal!");
        scanner.close();
    }
}

