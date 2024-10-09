// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1))
                p1 = i;

            if (wordsDict[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }
}