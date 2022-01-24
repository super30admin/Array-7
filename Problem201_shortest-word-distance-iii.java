// Time Complexity: O(n)
// Space Complexity: O(1)
import java.util.*;
class Solution {
    
    public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> locations = new HashMap<String, ArrayList<Integer>>();

        // Prepare a mapping from a word to all it's locations (indices).
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> loc = locations.getOrDefault(words[i], new ArrayList<Integer>());
            loc.add(i);
            locations.put(words[i], loc);
        }
        
        ArrayList<Integer> loc1, loc2;

        // Location lists for both the words
        // the indices will be in SORTED order by default
        loc1 = locations.get(word1);
        loc2 = locations.get(word2);

        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < loc1.size() && l2 < loc2.size()) {
            int idx1 = loc1.get(l1);
            int idx2 = loc2.get(l2);
            if(idx1 == idx2) {
                l2++;
                continue;
            }
            minDiff = Math.min(minDiff, Math.abs(idx1 - idx2));
            if (idx1 < idx2) {
                l1++;
            } else {
                l2++;
            }
        }

        return minDiff;
    }
}