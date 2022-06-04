// Time Complexity : O(n * l) where n is the no. of words and l is the length of word
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Same as shortest word dist 1.
// Just add condition when word1 and word2 are equal
// In this case assign p1 to p2 and p1 to i
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        boolean equal = word1.equals(word2);
        for(int i = 0; i < wordsDict.length; i++){
            String curword = wordsDict[i];
            if(curword.equals(word1)){
                if(equal)
                    p2 = p1;
                p1 = i;
            }    
            else if(curword.equals(word2))
                p2 = i;
            if(p1 != -1 && p2 != -1 ){
                int dif = Math.abs(p1 - p2);
                min = Math.min(min, dif);
            }
        }
        return min;
    }
}