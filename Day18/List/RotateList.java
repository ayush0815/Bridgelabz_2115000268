package List;
import java.util.*;
public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Input Rotation Count
        System.out.print("Enter rotation count: ");
        int k = sc.nextInt();
        k %= n; // Ensure rotation stays within bounds

        // Rotate Manually
        List<Integer> rotated = new ArrayList<>(list.subList(k, n));
        rotated.addAll(list.subList(0, k));

        System.out.println("Rotated List: " + rotated);
        sc.close();
    }
}

