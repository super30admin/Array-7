//TC: O(n)
//SC: O(1)

public class word_distance_3 {
    class Solution {
        //words are same - case 1
        //different words -case 2
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            int l1 = -1, l2 = -1;
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < wordsDict.length; i++) {
                if(wordsDict[i].equals(word1) && word1.equals(word2)) {
                    if(l1 == -1) {
                        l1 = i;
                    } else {
                        res = Math.min(res, Math.abs(l1 - i));
                        l1 = i;
                    }
                    
                } else {
                    if(wordsDict[i].equals(word1)) {l1 = i;};
                    if(wordsDict[i].equals(word2)) {l2 = i;};
                    
                    if(l1 != -1 && l2 != -1) {
                        res = Math.min(res, Math.abs(l1 - l2));
                    }
                }
                
            }
            
            return res;
        }
        }
}
