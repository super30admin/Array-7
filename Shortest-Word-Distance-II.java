// Time Complexity : O(N+k) , k = number of queries

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Iterate through the array, fill the map with the words and corresponding index.
// Get the lists of the word1 and word2 from the map and using two pointers find the min val.

// 243. Shortest Word Distance II

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {
    HashMap<String,List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            String curr = wordsDict[i];
            if(!map.containsKey(curr)){
                map.put(curr,new ArrayList<>());
            }
            map.get(curr).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1 < l1.size() && p2 < l2.size()){
            int val1 = l1.get(p1);
            int val2 = l2.get(p2);
            min = Math.min(min,Math.abs(val1 - val2));
            if(val1 < val2){
                p1++;
            }
            else{
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