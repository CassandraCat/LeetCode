/*
 * @lc app=leetcode id=1614 lang=javascript
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function (s) {
    let result = 0, count = 0
    for (var i = 0; i < s.length; i++) {
        if(s[i] === '(') {
            ++count
            result = Math.max(count,result)
        } else if(s[i] === ')') {
            --count
        }
    }
    return result
};
// @lc code=end

