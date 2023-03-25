class WordDistance {
    HashMap<String,List> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1<l1.size()&&p2<l2.size()){
            int idx1 = l1.get(p1);
            int idx2 = l2.get(p2);
            if(min==1) break;
            min = Math.min(min, Math.abs(idx1-idx2));
            if(idx1<idx2){
                p1++;
            }else{
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



// TC - O(p+q)
// SC - O(n)