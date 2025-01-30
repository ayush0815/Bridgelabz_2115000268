import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();
        int[] charCounts = new int[256]; // Assuming ASCII characters
        for (char c : str.toCharArray()) {
            charCounts[c]++;
        }


        char mostFrequentChar = ' ';
        int maxCount = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                mostFrequentChar = (char) i;
            }
        }


        System.out.println("Most Frequent Character: " + mostFrequentChar);
    }
}
