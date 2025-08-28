// Time Complexity : O(n)
// Reasoning: We make a single pass through the array of n words, updating indices and the running minimum in O(1) per element.
//
// Space Complexity : O(1)
// Reasoning: We use a constant number of integer variables (x1, x2, res) regardless of input size.
//
// Did this code successfully run on Leetcode : Yes

// Approach :
// 1) Initialize two pointers x1 and x2 to -1 to record the most recent indices where word1 and word2 are seen, and set res to Integer.MAX_VALUE to track the minimum distance.
// 2) Iterate once through the words array; for each word, if it equals word1 update x1 to the current index, and if it equals word2 update x2.
// 3) After each update, if both x1 and x2 are not -1, compute the absolute difference |x1 - x2| representing the distance between the latest occurrences.
// 4) Update the global minimum res with the smaller of the current res and the newly computed distance, ensuring we always keep the best seen so far.
// 5) After the loop ends, return res, which holds the shortest distance between any occurrence of word1 and word2 across the list.

// -------------------- Code --------------------
public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int x1 = -1, x2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.equals(word1)) {
                x1 = i;
            }
            if (s.equals(word2)) {
                x2 = i;
            }
            if (x1 != -1 && x2 != -1) {
                res = Math.min(res, Math.abs(x1 - x2));
            }
        }
        return res;
    }
}
