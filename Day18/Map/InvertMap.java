package Map;
import java.util.*;
public class InvertMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            String key = sc.nextLine();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            sc.nextLine();
            map.put(key, value);
        }

        // Invert the map
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        System.out.println("Inverted Map: " + invertedMap);
        sc.close();
    }
}

