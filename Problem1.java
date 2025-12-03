/*
Ran on leetcode: Yes
TC: O(n) SC: O(1)
With help of two pointers corresponding to word1 and word2 calculate the minumum distance
*/
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                p1 = i;
            }
            if (word.equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) { //it means they are at valid word pos
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;

    }
}
