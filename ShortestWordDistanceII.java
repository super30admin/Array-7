//Time Complexity : O(n) for adding words into the hash map, O(k1+k2) ~ O(max(k1, k2)) for iterating through the lists
//Space Complexity : O(1)
//Did this code run successfully on leetcode : Yes
//Have you faced any problem while running this code : No
class ShortestWordDistanceII {
    HashMap<String, List<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] wordsDict) {
        for(int i = 0; i < wordsDict.length; i++) {
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
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1 < l1.size() && p2 < l2.size()) {
            if(l1.get(p1) < l2.get(p2)) {
                min = Math.min(min, l2.get(p2) - l1.get(p1));
                p1++;
            } else {
                min = Math.min(min, l1.get(p1) - l2.get(p2));
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