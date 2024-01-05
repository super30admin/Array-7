// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1, i2 = -1, res = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                i1 = i;
            }
            if(wordsDict[i].equals(word2)){
                if(i == i1){
                    i1 = i2;
                }
                i2 = i;
            }
            if(i1!=-1 && i2!=-1)
            res = Math.min(res, Math.abs(i2-i1));
        }
        return res;
    }
}