// Time Complexity : Constructor: O(n) shortest: O(m+n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class WordDistance {
    
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(!map.containsKey(word)) {
                map.put(word, new LinkedList<>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        
        int i = 0;
        int j = 0;      
        
        int result = Integer.MAX_VALUE;               
        while (i < w1.size() && j < w2.size()) {
            result = Math.min(result, Math.abs(w1.get(i) - w2.get(j)));
            if (w1.get(i) < w2.get(j)) {
                i++;
            } else {
                j++;
            }                
        }
        return result;
    }
}
