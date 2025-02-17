import java.util.Arrays;
import java.util.Random;
public class SearchComparison {

    // Linear Search (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }

    // Binary Search (O(log N))
    public static int binarySearch(int[] arr, int target) {
        return Arrays.binarySearch(arr, target);
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        Random random = new Random();

        for (int N : datasetSizes) {
            // Generate a sorted dataset
            int[] dataset = new int[N];
            for (int i = 0; i < N; i++) {
                dataset[i] = i; // Sorted data
            }

            int target = random.nextInt(N); // Pick a random target

            // Measure Linear Search time
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long linearTime = System.nanoTime() - startTime;

            // Measure Binary Search time
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + N);
            System.out.println("Linear Search Time: " + (linearTime / 1_000_000.0) + " ms");
            System.out.println("Binary Search Time: " + (binaryTime / 1_000_000.0) + " ms");
        }
    }
}
