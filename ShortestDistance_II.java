import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LC 244
public class ShortestDistance_II {

    /**
     * Since we can have multiple queries for the same pair and the input array can be huge.
     * It will be complex to go through the array each time.
     * <p>
     * Hash it!
     */
    Map<String, List<Integer>> wordIndexMap;

    /**
     * TC: O(N)
     * SC: O(N)
     * @param wordsDict
     */
    public ShortestDistance_II(String[] wordsDict) {
        this.wordIndexMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            List<Integer> indices = wordIndexMap.computeIfAbsent(word, k -> new ArrayList<>());
            indices.add(i);
        }
    }

    /**
     * TC: O(m + n)
     * SC: O(1)
     * @param word1
     * @param word2
     * @return
     */
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> indices1 = wordIndexMap.get(word1);
        List<Integer> indices2 = wordIndexMap.get(word2);

        /*
        Find min. distance bw 2 sorted arrays

        Use 2 Pointers and move the smallest number pointer.
         */
        int len1 = indices1.size();
        int len2 = indices2.size();
        int p1 = 0, p2 = 0;
        while (p1 < len1 && p2 < len2) {
            int num1 = indices1.get(p1);
            int num2 = indices2.get(p2);
            int diff = Math.abs(num1 - num2);
            min = Math.min(min, diff);
            if (num1 < num2) {
                p1++;
            } else {
                p2++;
            }
        }
        return min;
    }
}
