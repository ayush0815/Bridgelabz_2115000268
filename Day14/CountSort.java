import java.util.Arrays;
public class CountSort {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1; // 18 - 10 + 1 = 9
        int[] count = new int[range]; // Count array for age frequencies
        int[] output = new int[ages.length]; // Output array for sorted ages
        // Step 1: Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }
        // Step 2: Compute cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Step 3: Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--; // Decrease count
        }
        // Copy sorted array back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }
     public static void main(String[] args) {
        int[] studentAges = {15, 12, 18, 10, 14, 17, 16, 13, 11, 12, 15, 18};
        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));

        countingSort(studentAges);

        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}
