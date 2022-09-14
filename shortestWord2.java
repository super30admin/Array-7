// Time Complexity :O(m+k)
// Space Complexity :constant 
class WordDistance {
    private HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        // create map to record indices of words so that we dont have to go through
        // whole list each time
        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);

        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;
        // get both lists and find minimum distance between the words
        while (p1 < li1.size() && p2 < li2.size()) {
            int idx1 = li1.get(p1);
            int idx2 = li2.get(p2);
            min = Math.min(min, Math.abs(idx2 - idx1));
            if (idx1 < idx2) {
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