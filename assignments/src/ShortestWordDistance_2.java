// Approach: Hashmap of (word, indexes) with 2 pointers search
// Time: O(n) + O(m + K) where m = li1.size() and K = li2.size()
// Space: O(n)

import java.util.*;

class ShortestWordDistance_2 {
    Map<String, List<Integer>> map;
    public ShortestWordDistance_2(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i<wordsDict.length; i++) {
            if (map.containsKey(wordsDict[i])) {
                map.get(wordsDict[i]).add(i);
            }
            else {
                final int j = i;
                map.put(wordsDict[i], new ArrayList<>(){{add(j);}});
            }
        }
        System.out.println(map);
    }

    public int shortest(String word1, String word2) {
        // two pointers on two lists
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;

        while (p1 < li1.size() && p2 < li2.size()) {
            int dist = Math.abs(li1.get(p1) - li2.get(p2));
            min = Math.min(min, dist);

            if (li1.get(p1) < li2.get(p2)) {
                p1++;
            }
            else p2++;
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */