/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = 0;
            int prev = i + 1;
            int end = len - 1;
            while (prev < end) {
                sum = nums[i] + nums[prev] + nums[end];
                if (sum == 0) {
                    List<Integer> items = new ArrayList<Integer>();
                    items.add(nums[i]);
                    items.add(nums[prev]);
                    items.add(nums[end]);
                    result.add(items);
                    while (++prev < end && nums[prev - 1] == nums[prev]) {

                    }
                    while (--end > prev && nums[end + 1] == nums[end]) {

                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    prev++;
                }
            }
        }
        return result;
    }
}
// @lc code=end
