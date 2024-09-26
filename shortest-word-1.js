// Time, Space - O(N), O(1)

var shortestDistance = function(words, word1, word2) {
    let j = -1;
    let k = -1;
    let min = Number.MAX_VALUE;
    
    for(let i=0;i<words.length;i++) {
        if(word1 === words[i]) {
            j = i;
        }
        if(word2 === words[i]) {
            k = i;
        }
        if(j!==-1 && k!==-1) {
            min = Math.min(Math.abs(j-k), min);   
        }
    }
    
    return min;
};
