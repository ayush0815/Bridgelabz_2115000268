import java.util.Scanner;
public class ReplaceWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.next();
        System.out.print("Enter the new word: ");
        String newWord = scanner.next();
        scanner.close();
        String replacedSentence = sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
        System.out.println("Replaced Sentence: " + replacedSentence);
    }
}

