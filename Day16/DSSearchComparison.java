import java.util.*;
public class DSSearchComparison {
    static int datasetSize = 1_000_000; // Change this value to test different dataset sizes
    static Random random = new Random();
    static int target; // Element to search

    public static void main(String[] args) {
        // Generate random dataset
        int[] array = new int[datasetSize];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < datasetSize; i++) {
            int value = random.nextInt(datasetSize * 10); // Ensures unique values
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }
        target = array[random.nextInt(datasetSize)]; // Pick a random target from dataset

        // Measure search time for Array (O(N))
        System.out.println("Searching in Array O(N)...");
        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long arrayTime = System.nanoTime() - startTime;
        System.out.println("Array Search Time: " + (arrayTime / 1_000_000.0) + " ms");

        // Measure search time for HashSet (O(1) on average)
        System.out.println("\nSearching in HashSet O(1)...");
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long hashSetTime = System.nanoTime() - startTime;
        System.out.println("HashSet Search Time: " + (hashSetTime / 1_000_000.0) + " ms");

        // Measure search time for TreeSet (O(log N))
        System.out.println("\nSearching in TreeSet O(log N)...");
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long treeSetTime = System.nanoTime() - startTime;
        System.out.println("TreeSet Search Time: " + (treeSetTime / 1_000_000.0) + " ms");
    }

    // Linear search (O(N)) for Array
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
