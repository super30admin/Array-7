public class ShortestWordDistance {
    /**
     Approach: two pointers. p1, p2 assinged to -1.
     when word 1 is found  update pointer 1 and when word 2 is found update pointer 2 with their indices.
     calculate the distance between them and assing to min. and int all the iterations calculate min
     Space -o(1)
     Time - o(n)



     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) {
            return 0;
        }
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                p1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
}
