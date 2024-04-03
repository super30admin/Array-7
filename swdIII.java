class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // Tc: O(n) Sc: O(1)
        int n = wordsDict.length;

        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String cur = wordsDict[i];
            if (cur.equals(word1)) {
                p1 = i;
            }
            if (cur.equals(word2)) {
                if (p1 == i)
                    p1 = p2;
                p2 = i;
            }

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }
        return min;
    }
}