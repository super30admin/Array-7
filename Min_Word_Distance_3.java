// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : NO, Premium question
// Any problem you faced while coding this : No


public int shortestWordDistance(String wordDict[], String word1, String word2){
    int i1 = -1;
    int i2 = -1;
    int min = Integer.MAX_VALUE;

    for(int i =0; i< wordDict.length; i++){
        String word = wordDict[i];
        
        if(!word1.equals(word2)){
            if(word1 == word){
                i1 = i;
            }
            if(word2 == word){
                i2 = i;
            }

            if(i1 != -1 && i2 != -1){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }
        else{
            if(word1.equals(word)){
                i1 = i;
            }
            if(word2.equals(word)){
                i1 = i2;
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                    min = Math.min(min, Math.abs(i1-i2));
            }
        }
    }
    return min;
}

// code length optimized
public int shortestWordDistance(String wordDict[], String word1, String word2){
    int i1 = -1;
    int i2 = -1;
    int min = Integer.MAX_VALUE;

    for(int i =0; i< wordDict.length; i++){
        String word = wordDict[i]; 
        if(word1 == word){
            i1 = i;
        }
        if(word2 == word){
            if(i1 == i){
                i1 = i2;
            }
            i2 = i;
        }
        if(i1 != -1 && i2 != -1){
            min = Math.min(min, Math.abs(i1-i2));
        }
    }
    return min;
}