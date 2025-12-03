/*
Ran on leetcode: Yes
TC: O(n) SC: O(1)
Using two pointers on the wordsDict where p1 corresponds to word1 and p2 corresponds to word2
When both the words are equal and one of the pointer is less than other then that pointer can be moved to the current index
*/

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = 9999;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word1.equals(word2)) {
                if (word.equals(word1)) {
                    if (p2 < p1) {
                        p2 = i;
                    } else {
                        p1 = i;
                    }
                }

            } else {
                if (word.equals(word1)) {
                    p1 = i;
                }
                if (word.equals(word2)) {
                    p2 = i;
                }
            }

            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
}
