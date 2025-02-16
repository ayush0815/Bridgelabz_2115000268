import java.util.Arrays;
public class LinearBinarySearch {
    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Place each number in its correct index (Cyclic Sort approach)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] and nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers are in place, return the next positive number
        return n + 1;
    }

    // Function to perform Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Example list of integers
        int[] nums = {3, 4, -1, 1, 5, 2, 6};
        
        // Finding the first missing positive number using Linear Search
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + missingNumber);

        // Sorting the array for Binary Search
        Arrays.sort(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));

        // Finding index of a target number using Binary Search
        int target = 4;
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of " + target + ": " + targetIndex);
    }
}
