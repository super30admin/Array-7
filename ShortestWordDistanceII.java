//TC: O(n*l)
//SC: O(n*l)
class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int m = l1.size(); int n = l2.size();
        int i1 = 0; int i2 = 0;
        while(i1 < m && i2 < n){
            min = Math.min(min, Math.abs(l1.get(i1) - l2.get(i2)));
            if(l1.get(i1) < l2.get(i2)){
                i1++;
            }
            else{
                i2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
