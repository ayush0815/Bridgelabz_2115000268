import java.util.Scanner;
public class StringReverse {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        
        String reversedString = reverse(input);
        System.out.println("Reversed string: " + reversedString);
    }
}
