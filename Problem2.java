/*
Ran on leetcode: Yes
TC: O(n) SC: O(1)
Using HashMap to store the word and thier occurence(indices)
With help of two pointers on the list retrieved by word1 and word2 get the minumum distance
*/

class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        for (int l1 : li1) {
            for (int l2 : li2) {
                minDist = Math.min(minDist, Math.abs(l1 - l2));
                if (l1 < l2)
                    p1++;
                else
                    p2++;
            }
        }
        return minDist;

    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
