//TC-O(n) SC O(1)
public class ShortWordDistanceI {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // Base case
        if (wordsDict == null || wordsDict.length == 0) {
            return -1;
        }
        // i1 and i2 for storing the positions of word1 and word2
        int i1 = -1;
        int i2 = -1;
        // Take min to store the minimum difference
        int min = Integer.MAX_VALUE;
        // Loop
        for (int i = 0; i < wordsDict.length; i++) {
            // Take one word at a time
            String word = wordsDict[i];
            // If equal to any word, store in i1 or i2
            if (word.equals(word1)) {
                i1 = i;
            }
            if (word.equals(word2)) {
                i2 = i;
            }
            // If both are not -1, calc difference
            if (i1 != -1 && i2 != -1) {
                min = Math.min(min, Math.abs(i1 - i2));
            }

        }
        // Return min
        return min;

    }
}
