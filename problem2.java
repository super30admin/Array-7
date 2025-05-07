import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// Time Complexity: O(n)
// Space Complexity: O(1)
public class problem2  {
      HashMap<String, List<Integer>> map;

    public void WordDistance(String[] wordsDict) {
        this.map= new HashMap<>();
        for (int i=0;i<wordsDict.length;i++)
        {
            String word= wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> word1List= map.get(word1);
        List<Integer> word2List= map.get(word2);
        int p1=0, p2=0;
        int min= Integer.MAX_VALUE;
        while (p1<word1List.size() && p2< word2List.size())
        {
            int index1= word1List.get(p1);
            int index2= word2List.get(p2);
            min = Math.min(min, Math.abs(index1- index2));
            if (index1< index2)
            {
               // min= Math.min(min, word2List.get(p2) - word1List.get(p1));
                p1++;
            }
            else {
               // min= Math.min(min, word2List.get(p2) - word1List.get(p1));
                p2++;
            }
        }
        return min;
    }
}
