// Time Complexity : O(nl)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        //two pointer approach
        for(int i=0; i<wordsDict.length; i++){
            if(word1.equals(wordsDict[i])){
                i1 = i;
            }
            if(word2.equals(wordsDict[i])){
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }
        return min;
    }
}