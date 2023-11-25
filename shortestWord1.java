// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // we'll use two pointers to find minimum distance
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            if (curr.equals(word1)) {
                p1 = i;
            } else if (curr.equals(word2)) {
                p2 = i;
            }
            // take minimum distance if we found both words
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
}
