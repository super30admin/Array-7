// Time complexity = O(n)
// Space complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) return -1;
        int i1=-1, i=0, n=wordsDict.length, min=Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;

        if (!word1.equals(word2)) {
            for (; i<n; i++) {
                if (wordsDict[i].equals(word1)) {
                    idx1 = i;
                }
                if (wordsDict[i].equals(word2)) {
                    idx2 = i;
                }
                if (idx1 != -1 && idx2 != -1) {
                    min = Math.min(min, Math.abs(idx1-idx2));
                }
            }
        }
        else {
            while (i<n) {
                if(wordsDict[i].equals(word1)) {
                    if (i1 == -1) {
                        i1=i;
                    }
                    if (i != i1) {
                        min = Math.min(min, i-i1);
                    }
                    i1 = i;
                }
                i++;
            }
        }

        return min;
    }
}