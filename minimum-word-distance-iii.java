// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min_distance = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            }
            
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    i1 = i2;
                }
                i2 = i;
            }
            
            int diff = Math.abs(i1 - i2);
            if (i1 != -1 && i2 != -1 && diff < min_distance) {
                min_distance = diff;
            }
        }
        
        return min_distance;
    }
}
