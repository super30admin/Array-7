// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) return 0;

        int i1=-1;
        int i2=-1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i< wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                i1=i;
            }
            if (word.equals(word2)) {
                i2=i;
            }
            if (i1 != -1 && i2 != -1) {
                min = Math.min(min, Math.abs(i1 -i2));
            }
        }

        return min;
    }
}