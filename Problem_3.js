// ## Problem 3: Minimum word distance iii (https://leetcode.com/problems/shortest-word-distance-iii/)

// TC: O(n)
// SC: O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


/**
 * @param {string[]} wordsDict
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var shortestWordDistance = function (wordsDict, word1, word2) {
    if (wordsDict === null || wordsDict.length === 0)
        return 0;
    let i1 = -1;
    let i2 = -1;
    let min = Infinity;
    let n = wordsDict.length;
    for (let i = 0; i < n; i++) {
        let word = wordsDict[i];
        if (word === word1) {
            i1 = i;
        }
        if (word === word2) {
            // If words are same
            if (i1 === i) {
                i1 = i2;
            }
            i2 = i;
        }
        if (i1 !== -1 && i2 !== -1) {
            min = Math.min(min, Math.abs(i1 - i2))
        }
    }
    return min;
};