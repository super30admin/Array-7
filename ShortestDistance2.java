// Problem244. Shortest Word Distance II
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class WordDistance {
    Map<String, List<Integer>> wordMap;
    public WordDistance(String[] wordsDict) {
        wordMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            wordMap.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer> indices1 = wordMap.get(word1);
        List<Integer> indices2 = wordMap.get(word2);
        int i = 0, j = 0, minDist = Integer.MAX_VALUE;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            minDist = Math.min(minDist, Math.abs(index1 - index2));
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1, word2);
 */