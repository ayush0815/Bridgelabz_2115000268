import java.util.Scanner;
public class RemoveDuplicateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        String result = "";
        boolean isDuplicate;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            isDuplicate = false;

            // Check manually if currentChar already exists in result
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result += currentChar;
            }
        }

        System.out.println("String without duplicates: " + result);
    }
}
