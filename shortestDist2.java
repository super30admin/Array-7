//time O(n)
//space O(n)

class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int p1 = 0; int p2 = 0;
        while(p1 < li1.size() && p2 < li2.size()) {
            min = Math.min(min, Math.abs(li1.get(p1) - li2.get(p2)));
            if(li1.get(p1) < li2.get(p2)) {
                p1++;
            } else {
                p2++;
            }
        }
        return min;
    }
}
