// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

        int res = Integer.MAX_VALUE;

        int w1 = -1;
        int w2 = -1;

        for(int i=0;i<wordsDict.length;i++){

            String s = wordsDict[i];

            // if the words are same
            if(word1.equals(word2) && s.equals(word1)){
                if(w1 >= 0){
                    res = Math.min(res,Math.abs(i-w1));
                }
                w1 = i;
            }
            // if the words are different
            else{
                if(s.equals(word1)){
                    w1 = i;
                }
                else if(s.equals(word2)){
                    w2 = i;
                }
                // find the distance when we found both the words
                if(w1 >= 0 && w2 >= 0){
                    res = Math.min(res,Math.abs(w2-w1));
                }
            }
        }
        return res;
    }
}