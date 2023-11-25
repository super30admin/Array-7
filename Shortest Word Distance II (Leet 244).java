/*
Time: O(k+l), two lists and O(n) for traversal ---> O(n)
Space: O(n)
Executed Successfully on Leet: Yes
*/


class WordDistance {
    HashMap <String,List<Integer>> hm;
    public WordDistance(String[] wordsDict) {
        hm = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String str = wordsDict[i];
            if (!hm.containsKey(str)){
                    hm.put(str, new ArrayList<>());
                }
            hm.get(str).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()){
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
