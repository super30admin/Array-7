//time O(n)
//space O(1)

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if(!word1.equals(word2)){
            int i1 = -1;
            int i2 = -1;
            for(int i = 0; i < wordsDict.length; i++) {
                if(wordsDict[i].equals(word1)) {
                    i1 = i;
                }
                if(wordsDict[i].equals(word2)) {
                    i2 = i;
                }
                if(i1 != -1 && i2 != -1) {
                    min = Math.min(min, Math.abs(i1-i2));
                }
            }
        } else {
            int i1 = -1;
            int i2 = -1;
            for(int i = 0; i < wordsDict.length; i++) {
                if(wordsDict[i].equals(word1)) {
                    if(i1 == i2) {
                        i1 = i;                    
                    } else {
                        if(i1 < i2) {
                            i1 = i;                                            
                        } else {
                            i2 = i;                                                                        
                        }
                    }
                    if(i1 != -1 && i2 != -1) {
                        min = Math.min(min, Math.abs(i1-i2));                    
                    }
                }
            }
            
        }
       return min; 
    }
}
