import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] examScores = {85, 72, 90, 60, 78, 88};
        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));

        selectionSort(examScores);
        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));
    }
}
