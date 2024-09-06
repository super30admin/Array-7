public class ShortestDistance3 {
    /**
     * two pointer assinged to -1
     * p1, p2.
     * min to infinity
     *
     Time Complexity
     o(n) - number of WorkArounds
     Space Complexity
     o(1) - Space
     *
     *
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!word1.equals(word2)) {
                if (word.equals(word1)) {
                    i1 = i;
                }
                if (word.equals(word2)) {
                    i2 = i;
                }
                if (i1 != -1 && i2 != -1) {
                    min = Math.min(min, Math.abs(i1 - i2));
                }
            }
            if (word1.equals(word2)) {
                if (word.equals(word1)) {
                    i1 = i;
                }
                if (word.equals(word2)) {
                    int temp = i2;
                    i1 = i2;
                    i2 = i;
                }
                if (i1 != -1 && i2 != -1) {
                    min = Math.min(min, Math.abs(i1 - i2));

                }
            }
        }
        return min;
    }
}
