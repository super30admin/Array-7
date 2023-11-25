// TC : O(N) + O(M) -> N = length of wordsDict, M = max length of word as equals() compare char-by-char but since we know MAX length of word could be 10, so O(M) ~= O(1)
// SC : O(1) 

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idxWord1 = -1, idxWord2 = -1; 
        int res = Integer.MAX_VALUE; /
        
        int idx = 0;
        for(String word : wordsDict) {
            if(word.equals(word1)) {
                idxWord1 = idx;
                if(idxWord2 != -1) { // this means we have already found word2 BEFORE word1
                    res = Math.min(res, idxWord1 - idxWord2);
                }
            }
            
            if(word.equals(word2)) {
                idxWord2 = idx;
                if(idxWord1 != -1) { // this means that we have already found word1 BEFORE word2
                    res = Math.min(res, idxWord2 - idxWord1);
                }
            }
            
            idx++;
        }
        
        return res;
    }
}