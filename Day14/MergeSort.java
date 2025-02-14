import java.util.Arrays;
public class MergeSort {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort both halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            // Merge sorted halves
            merge(prices, left, mid, right);
        }
    }
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(prices, left, leftArr, 0, n1);
        System.arraycopy(prices, mid + 1, rightArr, 0, n2);
        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }
        // Copy remaining elements of leftArr
        while (i < n1) {
            prices[k++] = leftArr[i++];
        }
        // Copy remaining elements of rightArr
        while (j < n2) {
            prices[k++] = rightArr[j++];
        }
    }
    public static void main(String[] args) {
        int[] bookPrices = {450, 300, 700, 200, 600, 500};
        System.out.println("Original Book Prices: " + Arrays.toString(bookPrices));

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Book Prices: " + Arrays.toString(bookPrices));
    }
}
