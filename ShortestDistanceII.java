// Time: O(L+K) | Space: O(N)

class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++) {
            if(!map.containsKey(wordsDict[i]))
                map.put(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> w1l= map.get(word1);
        List<Integer> w2l = map.get(word2);
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        while(i<w1l.size() && j<w2l.size()) {
            int firstIdx = w1l.get(i);
            int secondIdx = w2l.get(j);
            min = Math.min(min, Math.abs(firstIdx-secondIdx));
            if(firstIdx < secondIdx) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */