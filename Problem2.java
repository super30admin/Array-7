// Time Complexity : O(N)
// Space Complexity : O(N)
// Passed Leetcode

class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> w1List = map.get(word1);
        List<Integer> w2List = map.get(word2);
        int p1=0, p2 = 0;
        int dist = Integer.MAX_VALUE;
        int limit = Math.max(p1, p2);
        int i1, i2;
        while(p1 < w1List.size() && p2 < w2List.size()) {
            i1 = w1List.get(p1);
            i2 = w2List.get(p2);
            
            dist = Math.min(Math.abs(i1-i2), dist);
            
            if (i1 < i2) {
                p1++;
            } else {
                p2++; 
            }
                
        }
        return dist;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */