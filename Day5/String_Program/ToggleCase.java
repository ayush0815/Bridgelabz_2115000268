import java.util.Scanner;
public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        String toggledStr = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggledStr += Character.toLowerCase(c);
            } else {
                toggledStr += Character.toUpperCase(c);
            }
        }

        System.out.println("Toggled case string: " + toggledStr);
    }
}
