package List;
import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        List<String> list = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Count Frequency
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        System.out.println("Element Frequencies: " + freqMap);
        sc.close();
    }
}
