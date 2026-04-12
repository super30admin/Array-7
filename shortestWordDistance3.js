/**
Track the last seen indices of both words as you iterate.
If the words are the same, shift the previous index to avoid using the same position twice.
Continuously update the minimum distance between valid pairs.
T.C: O(n)
S.C: O(1)
 */
var shortestWordDistance = function(wordsDict, word1, word2) {
        let l1 = -1, l2 = -1;
    let minDist = Infinity;
    for(let i = 0; i<wordsDict.length; i++){
        let word = wordsDict[i];
        if(word === word1){
            l1 = i;
        } 
        
        if(word === word2){
            if(l1 === i){
                l1 = l2
            }
            l2 = i;
        }

        if(l1 !== -1 && l2 !== -1){
        minDist = Math.min(minDist, Math.abs(l1-l2));
        }
    }
    return minDist;
};