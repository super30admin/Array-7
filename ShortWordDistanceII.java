import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//TC-O(N) SC-O(N)
public class ShortWordDistanceII {
    HashMap<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            if (!map.containsKey(curr)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(curr, list);
            } else {
                map.get(curr).add(i);
            }
        }

    }

    public int shortest(String word1, String word2) {
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        int p1 = 0;
        int p2 = 0;
        int Min = Integer.MAX_VALUE;
        while (p1 < w1.size() && p2 < w2.size()) {
            int el1 = w1.get(p1);
            int el2 = w2.get(p2);
            Min = Math.min(Min, Math.abs(el1 - el2));
            if (el1 > el2) {
                p2++;

            } else {
                p1++;
            }

        }

        return Min;
    }
}
