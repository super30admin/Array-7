/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(1) where n is the length of the array
 */
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int result = Integer.MAX_VALUE;

        //Case 1 - words are same
        if (word1.equalsIgnoreCase(word2)) {
            int prevPos = -1;
            int currPos = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equalsIgnoreCase(wordsDict[i])) {
                    prevPos = currPos;
                    currPos = i;
                }

                if (prevPos != -1 && currPos != -1) {
                    result = Math.min(result, currPos - prevPos);
                }
            }
        } else {//Case 2 - words are different
            int posOfWord1 = -1;
            int posOfWord2 = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equalsIgnoreCase(wordsDict[i])) {
                    posOfWord1 = i;
                }
                if (word2.equalsIgnoreCase(wordsDict[i])) {
                    posOfWord2 = i;
                }

                if (posOfWord1 != -1 && posOfWord2 != -1) {
                    result = Math.min(result, Math.abs(posOfWord1 - posOfWord2));
                }
            }
        }

        return result;

    }
}