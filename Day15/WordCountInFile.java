import java.io.*;
import java.util.Scanner;
public class WordCountInFile {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into words based on spaces and punctuation
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the word to count: ");
        String targetWord = scanner.next();

        scanner.close();

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times in the file.");
    }
}
