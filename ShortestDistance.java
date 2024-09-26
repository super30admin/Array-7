// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int res = Integer.MAX_VALUE;
        int w1 = -1;
        int w2 = -1;

        for(int i=0;i<wordsDict.length;i++){
            String cur = wordsDict[i];

            //index of first word
            if(word1.equals(cur)){
                w1 = i;
            }

            //index of second word
            if(word2.equals(cur)){
                w2 = i;
            }

            // calculate the distance when we found both the words
            if(w1 >= 0 && w2 >= 0){
                res = Math.min(res,Math.abs(w2-w1));
            }
        }
        return res;
    }
}