/*
 * @lc app=leetcode id=674 lang=javascript
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function (nums) {
    let result = 0
    const number = nums.length
    let start = 0
    for (let i = 0; i < number; i++) {
        if (i > 0 && nums[i] <= nums[i - 1]) start = i
        result = Math.max(result, i - start + 1)
    }
    return result
};
// @lc code=end

