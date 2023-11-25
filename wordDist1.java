// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // approch 1 two pointer approch
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        // null case
        if (wordsDict == null || wordsDict.length == 0)
            return 0;

        // two pointers
        int i1 = -1;
        int i2 = -1;

        // go over dict and check for both
        // words if we found word1 update i1
        // if word2 update i2
        // count min distance
        int result = Integer.MAX_VALUE;
        int n = wordsDict.length;
        for (int i = 0; i < n; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                i1 = i;
            }
            if (word.equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                result = Math.min(result, Math.abs(i1 - i2));
                if (result == 1)
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[] {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        System.out.println(shortestDistance(wordsDict, word1, word2));
    }
}