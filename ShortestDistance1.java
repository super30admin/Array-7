/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(1)
 */
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int posOfWord1 = -1;
        int posOfWord2 = -1;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                posOfWord1 = i;
            } else if (word2.equals(wordsDict[i])) {
                posOfWord2 = i;
            }
            if (posOfWord1 != -1 && posOfWord2 != -1) {
                result = Math.min(result, Math.abs(posOfWord1 - posOfWord2));
            }
        }

        return result;
    }
}