/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int prev = i + 1;
            int end = nums.length - 1;
            while (prev < end) {
                int sum = nums[i] + nums[prev] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    prev++;
                }
                result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
            }
        }
        return result;
    }
}
// @lc code=end
