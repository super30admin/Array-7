// This alorithm builds a map with string to indices list
// For each string pair, we iterate through these lists and find the minimum difference between those numbers
class WordDistance {

    Map<String, List<Integer>> map = new HashMap();

    public WordDistance(String[] wordsDict) {
        for(int i=0;i<wordsDict.length;i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        return findShortest(map.get(word1), map.get(word2));
    }

    private int findShortest(List<Integer> list1, List<Integer> list2) {
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;

        while(i<list1.size() && j<list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i)-list2.get(j)));
            if(list1.get(i)<list2.get(j)) {
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
