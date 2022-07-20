public class ThirdMinWord {
    // TC : O(n * k) n - number of words k - average length of the word
    // SC : O(1)
    public int shortest(String[] wordsDict,String word1, String word2) {
        if(wordsDict == null || wordsDict.length == 0) return 0;

        int i1= -1, i2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < wordsDict.length; i++) {
            if(word1.equals(wordsDict[i])) {
                i1 = i;
            }

            if(word2.equals(wordsDict[i])) {
                if(i1 == i) {
                    i1 = i2;
                }
                i2 = i;
            }

            if(i1 != -1 && i2 != -1) min = Math.min(min, Math.abs(i1 - i2));

            if(min == 1) break; // if both are equal then the difference would be always 1. SO, skip other elements
        }

        return min;
    }
}
