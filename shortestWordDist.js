/**
 * @param {string[]} wordsDict
 */
var WordDistance = function (wordsDict) {
    this.words = wordsDict;
    this.map = new Map();
    wordsDict.forEach((word, idx) => {
        if (this.map.has(word)) {
            let currVal = this.map.get(word);
            currVal.push(idx);
        } else {
            this.map.set(word, [idx]);
        }
    });
};

/** .
 * @param {string} word1 
 * @param {string} word2
 * @return {number}
 */
WordDistance.prototype.shortest = function (word1, word2) {
    let word1Idx = this.map.get(word1);
    let word2Idx = this.map.get(word2);
    let min = Infinity;

    let p1 = 0, p2 = 0;
    while (p1 < word1Idx.length && p2 < word2Idx.length) {
        let p1Val = word1Idx[p1];
        let p2Val = word2Idx[p2];
        min = Math.min(min, Math.abs(p1Val - p2Val));
        if (p1Val < p2Val) {
            p1++;
        } else {
            p2++;
        }
    }
    return min;
};

/** 
*Preprocess the list by storing all indices of each word.
Use two pointers to scan the two index lists in sorted order.
Move the pointer with the smaller index to find the minimum gap efficiently.
T.C: O(m+k) // where m is the occurences of word 1, n is the occurence of the word 2
S.C: O(n)
 */