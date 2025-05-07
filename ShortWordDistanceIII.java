//TC-O(N) SC-O(1)
public class ShortWordDistanceIII {   public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    int i1 = -1, i2 = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < wordsDict.length; i++) {
        String curr = wordsDict[i];
        if (curr.equals(word1)) {
            i1 = i;
        }
        if (curr.equals(word2)) {
            if (i1 == i) {
                i1 = i2;
            }
            i2 = i;
        }
        if (i1 != -1 && i2 != -1) {
            min = Math.min(min, Math.abs(i1 - i2));
        }

    }
    return min;

}
}
