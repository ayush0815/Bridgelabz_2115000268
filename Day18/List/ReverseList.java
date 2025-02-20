package List;
import java.util.*;
public class ReverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Choose List Type
        System.out.print("Enter list type (ArrayList/LinkedList): ");
        String type = sc.next();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Create List
        List<Integer> list = type.equalsIgnoreCase("LinkedList") ? new LinkedList<>() : new ArrayList<>();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Reverse List
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        System.out.println("Reversed List: " + list);
        sc.close();
    }
}
