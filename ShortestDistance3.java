// Problem 245. Shortest Word Distance III
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int prevIndex = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (word1.equals(word2)) {
                    if (prevIndex != -1) {
                        minDist = Math.min(minDist, i - prevIndex);
                    }
                } else {
                    if (prevIndex != -1 && !wordsDict[i].equals(wordsDict[prevIndex])) {
                        minDist = Math.min(minDist, i - prevIndex);
                    }
                }
                prevIndex = i;
            }
        }
        return minDist;
    }
}