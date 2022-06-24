// Time Complexity : O(n) where n is length of wordsDict
// Space Complexity : O(1)

/**
 * @param {string[]} wordsDict
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var shortestWordDistance = function(wordsDict, word1, word2) {
    let minDist = Infinity;
    let p1 = -1;
    let p2 = -1;
    for(let i = 0; i < wordsDict.length; i++) {
        if(word1 !== word2) {
            if(wordsDict[i] === word1) p1=i;
            if(wordsDict[i] === word2) p2=i;
            if(p1 !== -1 && p2 !== -1) {
                minDist = Math.min(minDist, Math.abs(p2-p1));
            }
        } else {
            if(wordsDict[i] === word1) {
                if(p1 <= p2) {
                    p1 = i;
                } else {
                    p2 = i;
                }
                if(p1 !== -2 && p2 !== -1) {
                    console.log("I am here");
                    minDist = Math.min(minDist, Math.abs(p2-p1));
                }
            }
        }
    }

    return minDist;
};

//Solution 2 -> where we don't want to have seperate conditions to check if two words are equal or not

// /**
//  * @param {string[]} wordsDict
//  * @param {string} word1
//  * @param {string} word2
//  * @return {number}
//  */
//  var shortestWordDistance = function(wordsDict, word1, word2) {
//     let minDist = Infinity;
//     let p1 = -1;
//     let p2 = -1;
//     for(let i = 0; i < wordsDict.length; i++) {
//             if(wordsDict[i] === word1) p1=i;
//             if(wordsDict[i] === word2) {
//                 if(p1 === i) {
//                     //word1 and word2 are same
//                     p1 = p2;
//                 }
//                 p2 = i;
//             }
//             if(p1 !== -1 && p2 !== -1) {
//                 minDist = Math.min(minDist, Math.abs(p2-p1));
//             }
//         }
//     return minDist;
// };