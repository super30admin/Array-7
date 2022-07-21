import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {

    // TC : O (nk)
    // SC : O (m + n)
    // where n = total words, k = avg length of word, m = word repeating in dict
    Map<String, List<Integer>> map;

    public void WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int i1 = 0;
        int i2 = 0;
        int result = Integer.MAX_VALUE;
        while (i1 < l1.size() && i2 < l2.size()) {
            int idx1 = l1.get(i1);
            int idx2 = l2.get(i2);
            result = Math.min(result, Math.abs(idx1 - idx2));
            if (result == 1) return result;

            if (idx1 < idx2) {
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }
}
