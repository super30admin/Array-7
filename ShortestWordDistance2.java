
// In this problem, since we have sequence of word1 and word2, we will store all words in wordDict in the map with the list of their
// positions as value. Then when we want find the min distance between 2 words, we will get both the list and keep two pointers on 
// the list, then calc difference and move the pointer which has smaller value, and store the min difference in min.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

public class ShortestWordDistance2 {
    static HashMap<String, List<Integer>> map;

    public static void shortestDistance2(String[] wordsDict) {
        // Base case
        if (wordsDict == null || wordsDict.length == 0) {
            return;
        }
        map = new HashMap<>();
        // Loop and store the positions of each word as list
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }

    }

    public static int shortest(String word1, String word2) {
        // Get the two list
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        // Take the size
        int m = l1.size();
        int n = l2.size();
        // Pointers associated to list
        int p1 = 0;
        int p2 = 0;
        // Take min variable
        int min = Integer.MAX_VALUE;
        // Loop and check
        while (p1 < m && p2 < n) {
            // Take values
            int val1 = l1.get(p1);
            int val2 = l2.get(p2);
            // Calc min
            min = Math.min(min, Math.abs(val1 - val2));
            // Whichever val is smaller, increment that pointer
            if (val1 < val2) {
                p1++;
            } else {
                p2++;
            }
        }
        // Return min
        return min;
    }

    public static void main(String[] args) {
        String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };
        shortestDistance2(wordsDict);
        System.out.println(shortest("practice", "coding"));
        System.out.println(shortest("coding", "makes"));
    }
}
