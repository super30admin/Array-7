// 244.

class WordDistance {
    HashMap<String, List<Integer>> indexMap; //tracks indices at which each word occurs in words[]
    public WordDistance(String[] words) {
        indexMap = new HashMap<>();
        //the values to each key in map is list because it preserves insertion order and an increasing order of indices at which the key occurs is extracted
        for(int i = 0; i < words.length; i++)
        {
            String current = words[i];
            if(!indexMap.containsKey(current))
            {
                indexMap.put(current, new ArrayList<>());
            }
            indexMap.get(current).add(i);
        }
    }
    
    //time - O(# of occurences of word1 + # of occurences of word2)
    //space - constant ignoring the map
    public int shortest(String word1, String word2) {
        //get the list of indices at which each word occurs
        List<Integer> l1 = indexMap.get(word1);
        List<Integer> l2 = indexMap.get(word2);
        int i1 = 0; //i1 and i2 iteratesover wach index in l1 and l2
        int i2 = 0;
        int result = Integer.MAX_VALUE; //return value
        
        while(i1 < l1.size() && i2 < l2.size())
        {
            int w1 = l1.get(i1); //i1th occurence of word1
            int w2 = l2.get(i2); //i2nd occurence of word2
            int currentDist = Math.abs(w1 - w2); //distance considering w1 and w2 indices
            result = Math.min(result, currentDist); //update dist
            //moving the smaller pointer forward to find a smaller dist
            if(w1 < w2)
            {
                i1++;
            }
            else
            {
                i2++;
            }
        }
        
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
