// tc : O(n) for each search
// sc : O(unique words)

class WordDistance {
    private HashMap<String, List<Integer>> map ;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i  = 0 ; i < wordsDict.length ; i++){
            String word = wordsDict[i];
            map.computeIfAbsent(word,k -> new ArrayList<Integer>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i = 0, j = 0 ; i < list1.size() && j < list2.size() ; ){
            int ind1 = list1.get(i);
            int ind2 = list2.get(j);
            if(ind1 < ind2){
                res = Math.min(res, ind2 - ind1);
                i++;
            }
            else {
                res = Math.min(res, ind1 - ind2);
                j++;
            }
        }
        return res;
    }
}

// /**
//  * Your WordDistance object will be instantiated and called as such:
//  * WordDistance obj = new WordDistance(wordsDict);
//  * int param_1 = obj.shortest(word1,word2);
