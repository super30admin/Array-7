import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity: O(n)+O(k1+k2)
//Space Complexity: O(n)
//We store all positions of each word using a map during construction.
//For each query, we use two pointers to efficiently find the shortest distance between both words’ positions.
public class MinimumWordDistanceII {
    HashMap<String,List<Integer>> map;

    public WordDistance(String[] wordsDict)
    {
        this.map = new HashMap<>();
        int n = wordsDict.length;

        for(int i=0;i<n;i++)
        {
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2)
    {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;

        while (p1<list1.size() && p2< list2.size()) {
            if(list1.get(p1)<list2.get(p2))
            {
                min = Math.min(min,list2.get(p2)-list1.get(p1));
                p1++;
            }
            else{
                min = Math.min(min, list1.get(p1)- list2.get(p2));
                p2++;
            }
        }
return min;
    }
}
