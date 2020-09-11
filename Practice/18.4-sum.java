/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > 2; j--) {
                if (j != nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int prev = i + 1;
                int end = j - 1;
                int sum = 0;
                while (prev < end) {
                    sum = nums[i] + nums[prev] + nums[end] + nums[j];
                    if (sum == target) {
                        List<Integer> items = new ArrayList<Integer>();
                        items.add(nums[i]);
                        items.add(nums[prev]);
                        items.add(nums[end]);
                        items.add(nums[j]);
                        result.add(items);
                        while (++prev < end && nums[prev - 1] == nums[prev]) {

                        }
                        while (--end > prev && nums[end + 1] == nums[end]) {

                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        prev++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end
