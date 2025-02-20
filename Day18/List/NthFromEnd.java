package List;
import java.util.*;
public class NthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Input N
        System.out.print("Enter N from end");
        int k = sc.nextInt();

        // Two-pointer approach
        Iterator<String> fast = list.iterator(), slow = list.iterator();
        for (int i = 0; i < k; i++) {
            if (!fast.hasNext()) {
                System.out.println("N is larger than list size");
                return;
            }
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }


        System.out.println("Nth element from end: " + slow.next());
        sc.close();
    }
}
