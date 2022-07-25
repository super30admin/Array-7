//TC : O(nk) where n is the total words and k is the avg length of the word
//SC : O(n+m) where n is the number of words in Dict and m is the repeatnig number fo words
class WordDistance {
    HashMap<String,List<Integer>> hm;
    public WordDistance(String[] wordsDict) {
        hm = new HashMap();
        for(int i=0;i<wordsDict.length;i++){
            if(!hm.containsKey(wordsDict[i]))
                hm.put(wordsDict[i],new ArrayList());

            hm.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);

        int i1 = 0;
        int i2 = 0;
        int result = Integer.MAX_VALUE;
        while (i1 < l1.size() && i2 < l2.size()) {
            int idx1 = l1.get(i1);
            int idx2 = l2.get(i2);
            result = Math.min(result, Math.abs(idx1 - idx2));
            if (result == 1) return result;

            if (idx1 < idx2) {
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */