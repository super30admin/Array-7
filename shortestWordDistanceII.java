//Time Complexity : O(n)
//Space Complexity : O(n)

class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        for(int i = 0 ; i < wordsDict.length; i++)
        {
            if(!map.containsKey(wordsDict[i]))
            {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);

        int i1 = 0, i2 = 0;
        int min = Integer.MAX_VALUE;

        while(i1 < li1.size() && i2 < li2.size())
        {
            int val1 = li1.get(i1);
            int val2 = li2.get(i2);

            min = Math.min(min, Math.abs(val2 - val1));

            if(val1 < val2)
            {
                i1++;
            }
            else
            {
                i2++;
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