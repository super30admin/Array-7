// Time Complexity : 
// Constructor: O(n), where n is the number of words in wordsDict; we scan once and append indices in O(1) amortized per word.
// Query shortest(word1, word2): O(k1 + k2), where k1 and k2 are the counts of occurrences of word1 and word2; a single linear two-pointer merge.
// Reasoning: Building the index lists touches each word once; answering a query advances each pointer at most to the end of its list.
//
// Space Complexity : 
// O(n) total for the HashMap from word -> List of indices, since every position is stored exactly once across all lists.
// O(1) extra per query for a few pointers/integers.
//
// Did this code successfully run on Leetcode : Yes
//
// Approach :
// 1) Preprocess the dictionary in the constructor by mapping each unique word to a sorted list of all indices where it appears (inserted in order during the single pass).
// 2) For a query, fetch the two sorted index lists li1 and li2 corresponding to word1 and word2.
// 3) Use two pointers p1 and p2 starting at 0, compute the absolute difference between li1[p1] and li2[p2], and update the running minimum.
// 4) Advance the pointer pointing to the smaller index to potentially find a closer pair (because lists are sorted, moving the larger index cannot reduce the gap).
// 5) Continue until one list is exhausted; the recorded minimum is the shortest distance.
//
// -------------------- Code --------------------
import java.util.*;

public class WordDistance {

    private final HashMap<String, List<Integer>> map;

    public WordDistance(List<String> wordsDict) {
        this.map = new HashMap<>();
        for (int i = 0; i < wordsDict.size(); i++) {
            String curr = wordsDict.get(i);
            map.computeIfAbsent(curr, k -> new ArrayList<>()).add(i);
        }
    }

    /**
     * @param word1: word1
     * @param word2: word2
     * @return: the shortest distance between two words
     */
    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int p1 = 0, p2 = 0;
        int res = Integer.MAX_VALUE;

        while (p1 < li1.size() && p2 < li2.size()) {
            int val1 = li1.get(p1);
            int val2 = li2.get(p2);
            res = Math.min(res, Math.abs(val1 - val2));
            if (val1 < val2) {
                p1++;
            } else {
                p2++;
            }
        }
        return res;
    }
}
