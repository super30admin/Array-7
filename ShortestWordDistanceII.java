package array7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
	//Time Complexity : O(n), where n is length of wordDict array
	//Space Complexity : O(n), for HashMap
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	Map<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++) {
            String word = wordsDict[i];
            if(!map.containsKey(word))
                map.put(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int i=0, j = 0, min = Integer.MAX_VALUE;
        while(i < l1.size() && j < l2.size()) {
            min = Math.min(min, Math.abs(l1.get(i) - l2.get(j)));
            if(l1.get(i) < l2.get(j))
                i++;
            else
                j++;
        }
        
        return min;
    }
}
