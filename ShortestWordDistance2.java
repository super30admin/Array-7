import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2 {
    /**
     * iterate through dictoonary and use hashmap to add each word as key and its
     * indices as list in value.
     * get the lists of for both the input words indices from hashmap.
     * take two pointers one at the begining of each list.
     * calculate the distance between two indices. and assign to min.
     * since both lists are sorted,
     * move smaller pointer to minimize the distance. because if larger pointer is
     * moved distance might increase.
     * at the end of first list, return min
     * Time complexity - o(min(m,n)) - lenth of both ListSelectionEvent
     * Space complexity- 0(M) m+n
     *
     *
     *
     *
     */
    HashMap<String, List<Integer>> map;
    int min;

    public void WordDistance(String[] wordsDict) {
        if (wordsDict == null || wordsDict.length == 0) {
            return;
        }
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        min = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int p1 = 0;
        int p2 = 0;
        int m = l1.size();
        int n = l2.size();

        while (p1 < m && p2 < n) {
            int index1 = l1.get(p1);
            int index2 = l2.get(p2);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 < index2) {
                p1++;
            }
            if (index2 < index1) {
                p2++;
            }
        }
        return min;
    }
}
