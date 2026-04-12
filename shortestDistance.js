/**
 * Scan the array once while tracking the latest positions of word1 and word2.
Each time both are found, compute their index difference.
Keep updating the minimum distance seen so far.
 * T.C: O(N), S.C: O(1)
 */

var shortestDistance = function(wordsDict, word1, word2) {
    let l1 = -1, l2 = -1;
    let minDist = Infinity;
    for(let i = 0; i<wordsDict.length; i++){
        let word = wordsDict[i];
        if(word === word1){
            l1 = i;
        }else if(word === word2){
            l2 = i;
        }

        if(l1 !== -1 && l2 !== -1){
        minDist = Math.min(minDist, Math.abs(l1-l2));
        }
    }
    return minDist;
};