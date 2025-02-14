import java.util.Arrays;
public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) { 
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) { 
                if (marks[j] > marks[j + 1]) {  
                    // Swap elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps, array is already sorted
            if (!swapped) break;
        }
    }
    public static void main(String[] args) {
        int[] marks = {78, 55, 89, 42, 90, 67}; 
        System.out.println("Original Marks: " + Arrays.toString(marks));
        
        bubbleSort(marks);
        
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
    }
}
