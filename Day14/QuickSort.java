import java.util.Arrays;
public class QuickSort {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            // Recursively sort left and right partitions
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        // Swap pivot with the correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return pivot index
    }
     public static void main(String[] args) {
        int[] productPrices = {1200, 500, 700, 1500, 400, 1000};
        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
