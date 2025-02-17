import java.util.Arrays;
import java.util.Random;
public class SortingComparison {

    // Bubble Sort O(N²); Inefficient for large datasets
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; //Stop if already sorted
        }
    }

    // Merge Sort O(N log N) ; Stable sorting algo
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort O(N log N); Efficient but unstable sorting algo
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        Random random = new Random();

        for (int N : datasetSizes) {
            int[] dataset = new int[N];
            for (int i = 0; i < N; i++) {
                dataset[i] = random.nextInt(N);
            }

            int[] bubbleData = Arrays.copyOf(dataset, dataset.length);
            int[] mergeData = Arrays.copyOf(dataset, dataset.length);
            int[] quickData = Arrays.copyOf(dataset, dataset.length);
            System.out.println("Dataset Size: " + N);

            // Measure Bubble Sort Time
            long startTime = System.nanoTime();
            bubbleSort(bubbleData);
            long bubbleTime = System.nanoTime() - startTime;
            System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000.0) + " ms");

            // Measure Merge Sort Time
            startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = System.nanoTime() - startTime;
            System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000.0) + " ms");

            // Measure Quick Sort Time
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - startTime;
            System.out.println("Quick Sort Time: " + (quickTime / 1_000_000.0) + " ms");
        }
    }
}
