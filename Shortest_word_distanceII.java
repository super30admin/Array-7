//TC O(N)
//SC O(N)
class WordDistance {
    HashMap <String, List<Integer>> hashMap = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        for(int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];
            if(hashMap.containsKey(word)){
                hashMap.get(word).add(i);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(word,list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = hashMap.get(word1);
        List<Integer> l2 = hashMap.get(word2);
        
        int minDist = Integer.MAX_VALUE;
        
        int i1,i2, i = 0, j = 0;
        while(i< l1.size() && j < l2.size()){
            i1 = l1.get(i);
            i2 = l2.get(j);
            minDist = Math.min(minDist, Math.abs(i2-i1));
            if(i2 > i1){
                i += 1;
            }
            else{
                j += 1;
            }
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */