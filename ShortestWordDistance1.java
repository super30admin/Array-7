/**
 * Finds the shortest distance between two words in a list by tracking their latest indices.
 * Updates positions in one pass and computes minimum distance whenever both words are seen.
 * Time: O(n), Space: O(1).
 */
public class ShortestWordDistance1 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];

            if (word.equals(word1)) {
                index1 = i;
            }
            else if (word.equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                difference = Math.min(difference, Math.abs(index1 - index2));
            }
        }

        return difference;
    }
}