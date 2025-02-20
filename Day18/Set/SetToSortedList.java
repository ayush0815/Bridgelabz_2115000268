package Set;
import java.util.*;
public class SetToSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the set: ");
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        // Convert to Sorted List
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        System.out.println("Sorted List: " + sortedList);
        sc.close();
    }
}
