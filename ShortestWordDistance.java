// Keeping 2 indexes, initially -1. Then, looping over the wordsDict and whenever we find any matching word, we store it in i1 if 
// word1 is found else i2 if word2 is found. Then if both i1 and i2 are not -1, we compute the distance and store it in min.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class ShortestWordDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
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

    public static void main(String[] args) {
        String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };
        System.out.println(shortestDistance(wordsDict, "practice", "coding"));
    }
}
