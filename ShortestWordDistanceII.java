// Time Complexity : O(k1+k2) list of occurrences of word1 and word2
//constructor TC is not considered
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {

    HashMap<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] wordsDict) { //O(n)
        map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {  //O(k1+k2)
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int p1= 0 , p2=0;

        while(p1<li1.size() && p2<li2.size()){
            if(li1.get(p1)<li2.get(p2)){
                min = Math.min(min,li2.get(p2)-li1.get(p1));
                p1++;
            }else{
                min = Math.min(min,li1.get(p1)-li2.get(p2));
                p2++;
            }
        }
        return min;
    }
}
