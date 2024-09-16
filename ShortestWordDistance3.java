

// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes Both Approaches Worked
// 
/**
 * 
 * Algorthim 1
 * We can greatly improve on the brute-force approach by keeping two indices i1 and i2 where we store the most recent locations of word1 and word2. 
 * However if both words are same we can update both indices to same value
 * Each time we find a new occurrence of one of the words, we do not need to search the entire array for the other word, since we already have the index of its most recent occurrence.
 * 
 * Alogrthim 2
 *  Approach 1 makes use of word1.equals(word2) during iteration which is repetitive and gives same result 
 * So We can move word1.equals(word2) out of loop to avoid unnecessary computation
 */

class Solution {
   public int shortestWordDistance1(String[] words, String word1, String word2) {
    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    for (int i=0; i<words.length; i++) {
        if (words[i].equals(word1))
            i1 = i;
        if (words[i].equals(word2)) {
            if (word1.equals(word2))
                i1 = i2;
            i2 = i;
        }
        dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
}

public int shortestWordDistance2(String[] words, String word1, String word2) {
    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    boolean same = word1.equals(word2);
    for (int i=0; i<words.length; i++) {
        if (words[i].equals(word1)) {
            if (same) {
                i1 = i2;
                i2 = i;
            } else {
                i1 = i;
            }
        } else if (words[i].equals(word2)) {
            i2 = i;
        }
        dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
}
}