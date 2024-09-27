// Time Complexity : O(max(m,n)) ; m and b are indices length of word1 and word2
// Space Complexity : max no. of elements in nested list
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shortestWordDstance2 {

    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i< wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int i = 0, j = 0; //ptrs on li1 and li2
        int min = Integer.MAX_VALUE;

        while(i < li1.size() && j < li2.size()){
            int idx1 = li1.get(i);
            int idx2 = li2.get(j);

            min = Math.min(min, Math.abs(idx1 - idx2));
            if(idx1 < idx2){
                i++;
            }else{
                j++;
            }
        }
        return min;
    }

}
