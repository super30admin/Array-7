//TC: O(n)
//SC: O(n)
public class word_distance_2 {
    class WordDistance {

        Map<String,List<Integer>> map;
        
        public WordDistance(String[] wordsDict) {
            map = new HashMap<>();
            int idx = 0;
            for(String words : wordsDict) {
                map.computeIfAbsent(words, v->new ArrayList<Integer>()).add(idx++);
            }
        }
        
        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            
            int i = 0, j = 0, minLen = Integer.MAX_VALUE;
           while(i < l1.size() && j < l2.size()) {
             minLen =  Math.min(minLen,Math.abs(l1.get(i) - l2.get(j)));
             if(l1.get(i) < l2.get(j)) i++;
             else j++;        
           }
        return minLen;
        }
    }
}
