// Time, Space - O(N), O(1)
/**
 * @param {string[]} words
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var shortestWordDistance = function(words, word1, word2) {
  
    let j=-1, k=-1;
    let min = Number.MAX_VALUE;
    
    for(let i=0;i<words.length;i++) {
        let word = words[i];
        if(word === word1) {
            j = i;
        }
        if(word === word2) {
            if( j == i)  {
                j = k;
            }
            k = i;
        }
        if(j!= -1 && k != -1) {
            min = Math.min(min, Math.abs(j-k));
        }
    }
    
    return min;
    
};
