package List;
import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Remove Duplicates
        Set<Integer> seen = new LinkedHashSet<>(list);
        System.out.println("List after removing duplicates: " + new ArrayList<>(seen));
        sc.close();
    }
}
