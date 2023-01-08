// ## Problem 2: Minimum word distance ii (https://leetcode.com/problems/shortest-word-distance-ii/)

// TC: O(l)
// SC: O(nl), n is the number of words, l is average number of time it occurs

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {string[]} wordsDict
 */
var WordDistance = function (wordsDict) {
    let map = new Map();
    for (let i = 0; i < wordsDict.length; i++) {
        let word = wordsDict[i];
        if (!map.has(word)) {
            map.set(word, []);
        }
        map.get(word).push(i);
    }
    this.getMap = function () {
        return map;
    }
};

/** 
 * @param {string} word1 
 * @param {string} word2
 * @return {number}
 */
WordDistance.prototype.shortest = function (word1, word2) {
    let map = this.getMap();
    let l1 = map.get(word1);
    let l2 = map.get(word2);
    let min = Infinity;
    let p1 = 0, p2 = 0;
    while (p1 < l1.length && p2 < l2.length) {
        let val1 = l1[p1];
        let val2 = l2[p2];
        min = Math.min(min, Math.abs(val1 - val2))
        if (val1 < val2) {
            p1++;
        } else {
            p2++;
        }
    }
    return min;
};

/** 
 * Your WordDistance object will be instantiated and called as such:
 * var obj = new WordDistance(wordsDict)
 * var param_1 = obj.shortest(word1,word2)
 */
