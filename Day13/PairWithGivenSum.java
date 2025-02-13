import java.util.HashSet;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seenNumbers.contains(complement)) {
                return true;  // Found a pair
            }
            seenNumbers.add(num);  // Store visited number
        }
        return false;  // No pair found
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 8, 10};
        int target = 10;
        System.out.println(hasPairWithSum(nums, target));  // Output: true
    }
}
