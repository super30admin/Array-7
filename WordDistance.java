// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                index1 = i;
            else if (words[i].equals(word2))
                index2 = i;

            if (index1 != -1  && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                if (minDistance == 1) 
                return minDistance;
            }
        }
        return minDistance;
        
    }
}