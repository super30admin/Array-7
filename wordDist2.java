// Time Complexity : O(k + l)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class WordDistance {

    // approch 1 using hashMap
    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        // intialize the map
        map = new HashMap<>();
        int n = wordsDict.length;
        // create a map of list of indexes
        for (int i = 0; i < n; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        // find indexes from the map
        // for both the words
        // and get minimum distance
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);

        // two pointers
        // go over list and get minimum distance
        // for traversing whichever index is small
        // move pointer of that list
        int p1 = 0;
        int p2 = 0;
        int result = Integer.MAX_VALUE;
        while (p1 < li1.size() && p2 < li2.size()) {
            int idx1 = li1.get(p1);
            int idx2 = li2.get(p2);

            // calculate result and update result
            // with min value
            result = Math.min(result, Math.abs(idx1 - idx2));

            // whichever is smaller move that pointer

            if (idx1 < idx2) {
                p1++;
            } else {
                p2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordDistance wordDistance = new WordDistance(
                new String[] { "practice", "makes", "perfect", "coding", "makes" });
        System.out.println(wordDistance.shortest("coding", "practice")); // return 3
        System.out.println(wordDistance.shortest("makes", "coding")); // return 1
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
