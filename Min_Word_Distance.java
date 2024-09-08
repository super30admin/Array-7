// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : NO, Premium question
// Any problem you faced while coding this : No

public int shortestDistance(String wordDict[], String word1, String word2){
    int i1 = -1; 
    int i2 = -1;
    int min = Integer.MAX_VALUE;

    for(int i =0; i<wordDict.length; i++){
        if(wordDict[i] == word1){
            i1 = i;
        }
        if(wordDict[i] == word2){
            i2 = i; 
        }
        if(i1 != -1 && i2 != -1){
            min = Math.min(min, Math.abs(i2-i1));
        }
    }
    return min;
}