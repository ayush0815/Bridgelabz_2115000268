import java.util.Arrays;
public class HeapSort {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        // 1. Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        // 2. Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            // Restore heap property on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index 'i'
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i;   // Initialize largest as root
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        // If right child is larger than the current largest
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        // If largest is not root, swap and heapify the affected subtree
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;
            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] salaryDemands = {45000, 55000, 35000, 60000, 50000, 40000};
        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));

        heapSort(salaryDemands);

        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}
