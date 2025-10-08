//TC: O(n): single left-to-right pass over wordsDict.
//SC: O(1): constant indices (p1, p2) and min tracker.

//Scan once, updating p1 when word1 appears and p2 when word2 appears.
//Whenever both seen (p1 != -1 && p2 != -1), update min with |p1 - p2|.
//Return the smallest distance found.

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int n = wordsDict.length;

        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];

            if(word.equals(word1)) {
                p1 = i;
            }

            if(word.equals(word2)) {
                p2 = i;
            }

            if(p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }

        return min;
    }
}
