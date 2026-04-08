// Time Complexity : O(n*l)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Iterate over each word and update index of found word
// If both are found, start updating min distance

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (word1.equals(wordsDict[i]))
                p1 = i;
            if (word2.equals(wordsDict[i]))
                p2 = i;

            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }

        }

        return min;
    }
}