//TC : O(nk) where n is the number of words and k is the avg length of the word
//SC : O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) return 0;

        int i1 = -1;
        int i2 = -1;
        int result = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                i1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                if (i1 == i) {
                    i1 = i2;
                }
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                result = Math.min(result, Math.abs(i1 - i2));
            }
            if (result == 1) return result;
        }
        return result;
    }
}