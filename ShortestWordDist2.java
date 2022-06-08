//TC : O(n + m ) - Iterating over lists of size n and m where n and m is size of list (of indices ) for word1 and word2 
//SC : O(N) as we are using hashmap 
class WordDistance {
    HashMap<String, List<Integer> > map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        
        for(int i = 0; i< wordsDict.length; i++){ //Cresting hashmap from word to its indices in wordDict
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        //Get list of indiceds for word1 amnd word2
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1 < l1.size() && p2 < l2.size()){ //Iterate over it and find min diff.
            int i1 = l1.get(p1);
            int i2 = l2.get(p2);
            
            min = Math.min(min, Math.abs(i2-i1));
            
            if(i1 < i2) p1++;
            else
                p2++;
        }
        
        return min;
    }
}