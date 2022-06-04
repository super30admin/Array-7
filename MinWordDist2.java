// Time Complexity : O(N) for constructor and O(max(K,L)) where k and l are no. of times the words are there
// Space Complexity : O(N) for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store all the occurences of words in hashmap
// For two words get the lists of occurences from the map
// Since they are sorted, use two pointer find min diff
// Return the min diff
class WordDistance {
    Map<String, List<Integer>> hm;
    public WordDistance(String[] wordsDict) {
        hm = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String x = wordsDict[i];
            if(!hm.containsKey(x))
                hm.put(x, new ArrayList<Integer>());
            hm.get(x).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;  
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        int p1 = 0;
        int p2 = 0;
        while(p1 < l1.size() && p2 < l2.size()){
            int dif = Math.abs(l1.get(p1) - l2.get(p2));
            min = Math.min(min, dif);
            if(l1.get(p1) < l2.get(p2))
                p1++;
            else
                p2++;
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */