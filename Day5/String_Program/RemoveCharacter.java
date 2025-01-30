import java.util.Scanner;
public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);
        scanner.close();

        String modifiedString = "";
        for (char c : str.toCharArray()) {
            if (c != charToRemove) {
                modifiedString += c;
            }
        }

        System.out.println("Modified String: " + modifiedString);
    }
}
