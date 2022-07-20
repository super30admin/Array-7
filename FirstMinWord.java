public class FirstMinWord {
    // Approach 1
    // TC : O(n * k) n - number of words   k - average length of the word
    // SC : O(1)
    public int shortestDistance(String[] wordDict, String word1, String word2) {
        if(wordDict == null || wordDict.length == 0) return 0;

        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < wordDict.length;i++) {
            if(wordDict[i].equals(word1)){
                i1 = i;
            }

            if(wordDict[i].equals(word2)) {
                i2 = i;
            }
            min = Math.min(min, Math.abs(i1 - i2));
        }

        return min;
    }
}
