import java.util.HashSet;
import java.util.Set;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] counts = new int[51]; // Since nums[i] can be up to 50
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) { // Iterate through all starting positions of subarrays
            Set<Integer> subSet = new HashSet<>();
            for (int j = i; j < i + k; j++) { // Collect elements of the current subarray
                subSet.add(nums[j]);
            }
            for (int num : subSet) { // Update counts for each unique element in the subarray
                counts[num]++;
            }
        }

        // Find the largest number with count exactly 1
        for (int num = 50; num >= 0; num--) {
            if (counts[num] == 1) {
                return num;
            }
        }
        return -1;
    }
}
