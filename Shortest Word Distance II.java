class WordDistance {

    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        
        map = new HashMap();

        for(int i = 0; i < wordsDict.length; i++)
        {
            String word = wordsDict[i];

            if(!map.containsKey(word)) map.put(word, new ArrayList());

            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int i = 0, j = 0, minimum = Integer.MAX_VALUE;

        while(i < l1.size() && j < l2.size())
        {
            int index1 = l1.get(i);
            int index2 = l2.get(j);

            minimum = Math.min(minimum, Math.abs(index1 - index2));

            if(index1 < index2) i++;

            else j++;
        }

        return minimum;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */