//TC = O(N)
//SC = O(N)
class WordDistance {
    private HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();

        for(int i = 0; i < wordsDict.length; i++) {
            String currWord = wordsDict[i];
            if(!map.containsKey(currWord)) {
                map.put(currWord, new ArrayList<>());
            }
            map.get(currWord).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int p1 = 0; int p2 = 0;
        while(p1 < list1.size() && p2 < list2.size()) {
            int el1 = list1.get(p1);
            int el2 = list2.get(p2);
            min = Math.min(min, Math.abs(el1 - el2));
            if(el1 < el2) {
                p1++;
            } else {
                p2++;
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