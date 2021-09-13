class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i, w1, w2, min;
        w1 = -1;
        w2 = -1;
        min = Integer.MAX_VALUE;
        for(i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                w1 = i;
            } else if(wordsDict[i].equals(word2)) {
                w2 = i;
            }

            if(w1 != -1 && w2 != -1) {
                min = Math.min(min, Math.abs(w1 - w2));
            }
        }
        return min;
    }
}