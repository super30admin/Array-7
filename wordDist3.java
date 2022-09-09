// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1 using two pointers
    public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // null case
        if (wordsDict == null || wordsDict.length == 0)
            return 0;
        // two pointers
        int i1 = -1;
        int i2 = -1;
        int n = wordsDict.length;
        int result = Integer.MAX_VALUE;
        // go over dict and check for both
        // words if we found word1 update i1
        // if word2 update i2
        // count min distance
        // also handle same word case
        for (int i = 0; i < n; i++) {
            String word = wordsDict[i];

            if (word.equals(word1)) {
                i1 = i;
            }
            if (word.equals(word2)) {
                // to handle both same word
                if (i1 == i) {
                    i1 = i2;
                }
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                result = Math.min(result, Math.abs(i1 - i2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[] { "practice", "makes", "perfect", "coding", "makes", "coding" };
        String word1 = "coding", word2 = "coding";
        System.out.println(shortestWordDistance(wordsDict, word1, word2));
    }
}