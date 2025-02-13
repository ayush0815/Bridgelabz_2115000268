import java.util.HashMap;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores value index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Required number to reach target
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return indices
            }
            
            map.put(nums[i], i); // Store current number with index
        }
        return new int[]{}; // No valid pair found 
    }
     public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
