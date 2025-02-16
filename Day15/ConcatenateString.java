import java.util.Scanner;
public class ConcatenateString {
    public static String concatenateString(String[] words) {
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        scanner.close();

        String result = concatenateString(words);
        System.out.println("Concatenated String: " + result);
    }
}
