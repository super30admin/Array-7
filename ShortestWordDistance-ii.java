// Approach : since to find the min ditance between words then we need to know these words are located at what index.
// Hence use map to store them and calculate the difference of the index locations of these words for distance
// Time : O(N + m + l)
// Space : O(N) // Create a map of wordDict size
class WordDistance {
    HashMap<String , List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            String word = wordsDict[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int pt1 =0;
        int pt2 =0;
        int min = Integer.MAX_VALUE;
        while(pt1<l1.size() && pt2<l2.size()){
            int v1 = l1.get(pt1);
            int v2 = l2.get(pt2);
            min = Math.min(min , Math.abs(v1-v2));

            if(v1 < v2){
                pt1++;
            } else{
                pt2++;
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