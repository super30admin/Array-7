// Time Complexity : O(N)
// Space Complexity : O(1)
// Passed Leetcode

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        
        int p1=-1, p2=-1;
        int dist = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                
                if (i == p1) {
                    p1 = p2;
                }
                p2 = i;
            }
            
            if (p1 != -1 && p2 != -1) {
                dist = Math.min(Math.abs(p1-p2), dist);
            }
        }
        return dist;
        
    }
}