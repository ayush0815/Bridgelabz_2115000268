import java.util.Scanner;
public class SubStringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scanner.nextLine();
        System.out.print("Enter the substring: ");
        String substring = scanner.nextLine();
        scanner.close();

        int count = 0;
        int strLength = str.length();
        int subLength = substring.length();

        for (int i = 0; i <= strLength - subLength; i++) {
            boolean found = true;
            for (int j = 0; j < subLength; j++) {
                if (str.charAt(i + j) != substring.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }

        System.out.println("Number of occurrences: " + count);
    }
}
