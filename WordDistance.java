//Time Complexity O(N)
//Space ComplexityO(N)
//LeetCode tested

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict){
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i],new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    public int shortest(String word1,String word2){
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        int p1=0;int p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1<li1.size() && p2<li2.size()){
            int idx1 =li1.get(p1);
            int idx2 =li2.get(p2);
            min = Math.min(min,Math.abs(idx1-idx2));
            if(min == 1) break;
            if(idx1<idx2) p1++;
            else p2++;
        }
        return min;
    }
}
