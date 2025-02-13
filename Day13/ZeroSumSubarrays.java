import java.util.*;
class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Add base case for sum=0 at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Compute cumulative sum
            // If sum was seen before, it means subarrays exist
            if (sumMap.containsKey(sum)) {
                for (int startIndex : sumMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            // Add current index to the list of indices for this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 1, 3, 3, 1, -4};
        List<int[]> subarrays = findZeroSumSubarrays(nums);

        System.out.println("Zero-Sum Subarrays:");
        for (int[] pair : subarrays) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
