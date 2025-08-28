// Time Complexity : O(n)
// Reasoning: We traverse the words array once, updating indices and the current minimum in constant time per element.
//
// Space Complexity : O(1)
// Reasoning: Only a fixed number of integer variables (p1, p2, min, n) are used regardless of input size.
//
// Did this code successfully run on Leetcode : Yes
//
// Approach :
// 1) Maintain two pointers p1 and p2 (initialized to -1) to remember the latest seen indices of word1 and word2, and a running minimum distance.
// 2) Iterate through wordsDict once; when the current word equals word1, update p1 to the current index.
// 3) When the current word equals word2, first check if word1 == word2 by testing p1 == i; if true, shift p1 to p2 so p1 holds the previous occurrence before setting p2 to i.
// 4) After processing the current position, if both pointers are valid (not -1), compute |p1 - p2| and minimize the global answer.
// 5) This logic handles both distinct-word and same-word cases in one pass by always comparing the current occurrence to the most recent opposite (or previous same) occurrence.

// -------------------- Code --------------------
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;

        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String word = wordsDict[i];

            if (word.equals(word1)) {
                p1 = i;
            }

            if (word.equals(word2)) {
                if (p1 == i) { // handles the case when word1 == word2; compare previous occurrence vs current
                    p1 = p2;
                }
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }

        return min;
    }
}
