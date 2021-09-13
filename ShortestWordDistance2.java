class WordDistance {

    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            if(!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int p1, p2, min;
        min = Integer.MAX_VALUE;
        p1 = 0;
        p2 = 0;
        while(p1 < l1.size() && p2 < l2.size()) {
            int index1 = l1.get(p1);
            int index2 = l2.get(p2);
            min = Math.min(min, Math.abs(index1 - index2));
            if(index1 < index2) {
                p1++;
            } else {
                p2++;
            }
        }
        return min;
    }
}