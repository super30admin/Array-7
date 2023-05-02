// Time complexity : O(n)
// Space complexity : O(1)

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i<wordsDict.length; i++) {
            String currWord = wordsDict[i];

            if (currWord.equals(word1)) {
                p1 = i;
            }
            if (currWord.equals(word2)) {
                if (p1 == i) {          
                    p1 = p2;
                }
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }
}