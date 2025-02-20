package Map;
import java.util.*;
public class MergeTwoMaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        System.out.print("Enter number of entries in first map");
        int n1 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter key");
            String key = sc.nextLine();
            System.out.print("Enter value");
            int value = sc.nextInt();
            sc.nextLine();
            map1.put(key, value);
        }

        System.out.print("Enter number of entries in second map");
        int n2 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter key: ");
            String key = sc.nextLine();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            sc.nextLine();
            map2.put(key, value);
        }

        // Merge maps
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.put(entry.getKey(), mergedMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        System.out.println("Merged Map: " + mergedMap);
        sc.close();
    }
}
