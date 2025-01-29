import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("I've chosen a number between 1 and 100. Try to guess it!");

        do {
            guess = getGuess(scanner);
            attempts++;
            String feedback = getFeedback(guess, secretNumber);
            System.out.println(feedback);
        } while (guess != secretNumber);

        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        scanner.close();
    }

    private static int getGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    private static String getFeedback(int guess, int secretNumber) {
        if (guess < secretNumber) {
            return "Too low!";
        } else if (guess > secretNumber) {
            return "Too high!";
        } else {
            return "Correct!";
        }
    }
}