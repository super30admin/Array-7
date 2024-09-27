// TC - O(n)

// SC - O(n)

// LC - 244

class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        

        int min = Integer.MAX_VALUE;
        if(l1.size() == 0 || l2.size() == 0){
            return -1;
        }
        
        int p1 = 0, p2 = 0;
        
        while(p1 < l1.size() && p2 < l2.size()){
            min = Math.min(min, Math.abs(l1.get(p1) - l2.get(p2)));
            
            if(l1.get(p1) < l2.get(p2)){
                p1++;
            }else{
                p2++;
            }
        }
        
        return min;
    }
}


// class WordDistance {
//     private Map<String, List<Integer>> map;
//     public WordDistance(String[] wordsDict) {
//         map = new HashMap<>();
//         for(int i=0; i<wordsDict.length; i++){
//             map.putIfAbsent(wordsDict[i], new ArrayList<>());
//             map.get(wordsDict[i]).add(i);
//         }
//     }
    
//     public int shortest(String word1, String word2) {
//         List<Integer> l1 = map.get(word1);
//         List<Integer> l2 = map.get(word2);
        

//         int min = Integer.MAX_VALUE;
//         if(l1.size() == 0 || l2.size() == 0){
//             return -1;
//         }
//         for(int i=0; i<l1.size(); i++){
//             for(int j=0; j<l2.size(); j++){
//                 min = Math.min(min, Math.abs(l1.get(i) - l2.get(j)));
//             }
//         }
//         return min;
//     }
// }


/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */