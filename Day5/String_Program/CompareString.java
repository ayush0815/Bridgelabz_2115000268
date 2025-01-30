import java.util.Scanner;
public class CompareString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string 1: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter string 2: ");
        String str2 = scanner.nextLine();
        scanner.close();


        int len1 = str1.length();
        int len2 = str2.length();
        int limit = Math.min(len1, len2);
        for (int i = 0; i < limit; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                System.out.println(str1 + " comes before " + str2 + " in lexicographical order");
                return;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                System.out.println(str2 + " comes before " + str1 + " in lexicographical order");
                return;
            }
        }

        if (len1 < len2) {
            System.out.println(str1 + " comes before " + str2 + " in lexicographical order");
        } else if (len1 > len2) {
            System.out.println(str2 + " comes before " + str1 + " in lexicographical order");
        } else {
            System.out.println("The strings are equal.");
        }
    }
}
