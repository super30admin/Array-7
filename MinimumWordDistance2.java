//TC: O(n) for constructing map, where n=length of string array,
//      O(m+n) for shortest distance, where n, m are number of occurrences of words 1 and 2, meaning list size in map
//SC: O(n)
//approach: hashing, two pointers

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWordDistance2 {
    HashMap<String, List<Integer>> hashMap;

    public void WordDistance(String[] words) {
        hashMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (hashMap.containsKey(word)) {
                hashMap.get(word).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(word, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> w1 = hashMap.get(word1);
        List<Integer> w2 = hashMap.get(word2);
        int min = Integer.MAX_VALUE;
        int i1;
        int i2;
        int i = 0, j = 0;

        while (i < w1.size() && j < w2.size()) {
            i1 = w1.get(i);
            i2 = w2.get(j);

            min = Math.min(min, Math.abs(i1 - i2));

            if (i2 > i1)
                i += 1;
            else
                j += 1;
        }
        return min;
    }
}
