import java.util.HashSet;
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;  // Edge case: empty array
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);  // Store all numbers in HashSet for quick lookup
        }
        int maxLength = 0;
        for (int num : nums) {
            // Only start counting if `num - 1` is NOT in the set (i.e., `num` is the beginning of a sequence)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                // Check consecutive elements
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                // Update the maximum sequence length
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));  // Output: 4
    }
}
