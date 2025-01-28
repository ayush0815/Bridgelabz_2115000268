package L2;
import java.util.Scanner;

public class YoungestAndTallest {

    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int age : ages) {
            if (age < youngest) {
                youngest = age;
            }
        }
        return youngest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for friend " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height for friend " + (i + 1) + ": ");
            heights[i] = scanner.nextInt();
        }

        System.out.println("Youngest friend is: " + findYoungest(ages));
        System.out.println("Tallest friend is: " + findTallest(heights));
        scanner.close();
    }
}
