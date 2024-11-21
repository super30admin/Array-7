import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondMinWord {
    Map<String, List<Integer>> map;
    public SecondMinWord(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0; i < wordsDict.length;i++) {
            String word = wordsDict[i];
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int p1 = 0;
        int p2 = 0;

        while(p1 < list1.size() && p2 < list2.size()) {
            int idx1 = list1.get(p1);
            int idx2 = list2.get(p2);

            min = Math.min(min, Math.abs(idx1 - idx2));
            if(idx1 < idx2) p1++;
            else p2++;
        }

        return min;
    }
}
