// Time Complexity : O(n * l) where n is the no. of words and l is the length of word
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take two pointers 1 each for word1 and word2
// If you see word 1 assign index to it, do same for word2
// Check dif between these each time and keep track of min 
// Return the min value
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            String curword = wordsDict[i];
            if(curword.equals(word1))
                p1 = i;
            else if(curword.equals(word2))
                p2 = i;
            if(p1 != -1 && p2 != -1){
                int dif = Math.abs(p1 - p2);
                min = Math.min(min, dif);
            }
        }
        return min;
    }
}