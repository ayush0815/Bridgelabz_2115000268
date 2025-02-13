import java.util.*;
class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Result array
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add the current element index
            deque.offerLast(i);

            // Store the maximum for the window (only after the first k elements)
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxValues = maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximum:");
        printArray(maxValues);
    }
}
