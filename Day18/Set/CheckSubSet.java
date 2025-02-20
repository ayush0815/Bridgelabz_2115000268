package Set;
import java.util.*;
public class CheckSubSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in Subset");
        int n1 = sc.nextInt();
        Set<Integer> subset = new HashSet<>();
        System.out.println("Enter elements of Subset");
        for (int i = 0; i < n1; i++) {
            subset.add(sc.nextInt());
        }

        System.out.print("Enter number of elements in Main Set");
        int n2 = sc.nextInt();
        Set<Integer> mainSet = new HashSet<>();
        System.out.println("Enter elements of Main Set:");
        for (int i = 0; i < n2; i++) {
            mainSet.add(sc.nextInt());
        }

        // Check if Subset
        System.out.println("Is subset present? " + mainSet.containsAll(subset));
        sc.close();
    }
}

