//TC: O(m+k)
//SC: O(n)
//Running on leetcode: yes
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1 < li1.size() && p2 < li2.size()) {
            int index1 = li1.get(p1);
            int index2 = li2.get(p2);
            min = Math.min(min, Math.abs(index1 - index2));
            if(index1 < index2) {
                p1++;
            }
            else {
                p2++;
            }
        }
        return min;
    }
}
