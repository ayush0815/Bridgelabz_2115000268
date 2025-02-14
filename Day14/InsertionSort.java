import java.util.Arrays;
public class InsertionSort {
    public static void insertionSort(int[] empIDs) {
        int n = empIDs.length;
        for (int i = 1; i < n; i++) {
            int key = empIDs[i]; // Pick the element to be inserted
            int j = i - 1;
            // Shift elements greater than key to the right
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }
            empIDs[j + 1] = key; // Insert key at correct position
        }
    }
    public static void main(String[] args) {
        int[] empIDs = {103, 101, 105, 100, 102, 104}; 
        System.out.println("Original Employee IDs: " + Arrays.toString(empIDs));
        
        insertionSort(empIDs);
        
        System.out.println("Sorted Employee IDs: " + Arrays.toString(empIDs));
    }
}
