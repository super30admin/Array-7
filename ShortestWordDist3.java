//TC : O(N)  and SC : O(1)
//AS we are iterating over wordDict in linear time

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< wordsDict.length; i++){
            if(word1.equals(wordsDict[i]) ){
                p1 = i;
            }
            if(word2.equals(wordsDict[i]) ){
                //When both words are same then
                if(p1 == i){
                    p1 = p2;
                }
                p2 = i;
            }
            if(p1 != -1 && p2 != -1){
                min = Math.min(Math.abs(p2 - p1), min);
            }
        }
        
        return min;
    }
}