// Time Complexity : O(n) where n is length of wordsDict
// Space Complexity : O(1)

/**
 * @param {string[]} wordsDict
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */

var shortestDistance = function(wordsDict, word1, word2) {
    let p1 = -1;
    let p2 = -1;
    let minDist = Infinity
    for(let i = 0; i < wordsDict.length; i++) {
        if(wordsDict[i] === word1) p1=i;
        if(wordsDict[i] === word2) p2=i;
        if(p1 !== -1 && p2 !== -1) {
            minDist = Math.min(minDist, Math.abs(p2-p1));
        }
    }
    return minDist;
};