// Time, Space - O(N), O(N)

/**
 * @param {string[]} words
 */

let map;
var WordDistance = function(words) {
    map = {}
    
    for(let i=0;i<words.length;i++) {
        let word = words[i];
        map = {
            ...map,
            [word]: map[word] ? [...map[word], i] : [i]
        }
    }
    
};

/** 
 * @param {string} word1 
 * @param {string} word2
 * @return {number}
 */
WordDistance.prototype.shortest = function(word1, word2) {
    
    let p1 = 0;
    let p2 = 0;
    let min = Number.MAX_VALUE;
    while(p1 < map[word1].length && p2 < map[word2].length) {
         
        let index1 = map[word1][p1];
        let index2 = map[word2][p2];
        
        if(index1 < index2) {
            p1++;
        }
        else {
            p2++;
        }
        
        min = Math.min(min, Math.abs(index1 - index2));
    } 
    
    return min;
};

/** 
 * Your WordDistance object will be instantiated and called as such:
 * var obj = new WordDistance(words)
 * var param_1 = obj.shortest(word1,word2)
 */
