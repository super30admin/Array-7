class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // Tc: O(n) Sc: O(1)
        if (wordsDict == null)
            return 0;
        int minim = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                p1 = i;
            }
            if (word.equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                minim = Math.min(minim, Math.abs(p2 - p1));
            }
        }

        return minim;
    }
}