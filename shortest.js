// Time Complexity : O(m+k) where m and k is no. of times word1 and word2 occuring in wordsDict array
// Space Complexity : O(n)

let hashMap; 

/**
 * @param {string[]} wordsDict
 */
var WordDistance = function(wordsDict) {
    hashMap = new Map();
    for(let i = 0; i < wordsDict.length; i++) {
        if(!hashMap.has(wordsDict[i])) {
            hashMap.set(wordsDict[i],[]);
        }
        hashMap.get(wordsDict[i]).push(i);
    }
};

/** 
 * @param {string} word1 
 * @param {string} word2
 * @return {number}
 */
WordDistance.prototype.shortest = function(word1, word2) {
    let list1 = hashMap.get(word1);
    let list2 = hashMap.get(word2);
    let p1=0, p2=0;
    let minDist = Infinity;
    while(p1 !== list1.length && p2 !== list2.length) {
        minDist = Math.min(minDist, Math.abs(list2[p2] - list1[p1]));
        if(minDist === 1) break;
        if(list1[p1] < list2[p2]) p1++;
        else p2++;
    }
    return minDist;
};

/** 
 * Your WordDistance object will be instantiated and called as such:
 * var obj = new WordDistance(wordsDict)
 * var param_1 = obj.shortest(word1,word2)
 */