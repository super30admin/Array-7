// Time Complexity: O(N)
// Space Complexity: O(N)
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i=0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        int p1=0;
        int p2=0;

        while(p1 < l1.size() && p2 < l2.size()) {
            int num1 = l1.get(p1);
            int num2 = l2.get(p2);
            min = Math.min(min, Math.abs(num1 - num2));
            if (num1 < num2) {
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