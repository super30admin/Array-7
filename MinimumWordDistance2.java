// Time O(k+l) where k is thenumber of occurences of word1 and l is the number of occurences of word2
// Space O(1) because the ashmap initialization is a one time thing

class WordDistance {
    HashMap<String,List<Integer>> hash = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        for(int i =0;i<wordsDict.length;i++)
        {
            List<Integer> temp = hash.getOrDefault(wordsDict[i],new ArrayList<>());
            temp.add(i);
            hash.put(wordsDict[i],temp);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        
        int p1=0, p2=0;
        
        List<Integer> temp1 = hash.get(word1);
        List<Integer> temp2 = hash.get(word2);
        int min = Integer.MAX_VALUE;
        while(p1<temp1.size()&& p2<temp2.size())
        {
            int first =temp1.get(p1);
            int second = temp2.get(p2);
            min = Math.min(min, Math.abs(first-second));
            if(first<second) p1++;
            else p2++;
        }
        return min;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */