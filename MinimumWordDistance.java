// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We use two pointers approach to solve this problem. We capture the occurence of word1 in first and word2 in second and maintain
// the minimum distance in result while traversing the wordDict array.

class Solution {
    int shortestDistance(String[] wordsDict, String word1, String word2) {
        int first = -1;
        int second = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                first = i;//first occurence index
            }
            if (wordsDict[i].equals(word2)) {
                second = i;//second occurence index
            }
            if (first != -1 && second != -1) {
                res = Math.min(res, Math.abs(first - second));//minimum distance
            }
        }

        return res;
    }
}
