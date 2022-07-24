/*
 * @lc app=leetcode id=77 lang=javascript
 *
 * [77] Combinations
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
    const result = []
    const current = []
    function dfs(start, n, k) {
        if (k === 0) {
            result.push([...current])
            return
        }
        for (let i = start; i <= n; i++) {
            current.push(i)
            dfs(i + 1, n, k - 1)
            current.pop()
        }
    }

    dfs(1, n, k)
    return result
};
// @lc code=end

