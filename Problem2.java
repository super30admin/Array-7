/*
244. Shortest Word Distance II
Ran on leetcode: Yes
TC: O(n) SC: O(n)
Since we are going to call the shortest function n times, store the locations of words in a map, get all the locations of both the words, start with first location of each word if the word1 is farther than word2 check the next location of word2 and vice versa, at each point calculate distance and store it in min
*/
class WordDistance {
    private Map<String, List<Integer>> locMap;

    public WordDistance(String[] wordsDict) {
        // Store the index at which word1 and word2 exists
        this.locMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            locMap.putIfAbsent(word, new ArrayList<>());
            locMap.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1Locs = locMap.get(word1); // Get all locations of word1
        List<Integer> word2Locs = locMap.get(word2); // Get all locations of word2
        int p1 = 0; // Track the word1 list
        int p2 = 0; // Track the word2 list
        int min = Integer.MAX_VALUE;

        while (p1 < word1Locs.size() && p2 < word2Locs.size()) { // Check if we are inbounds
            if (word1Locs.get(p1) > word2Locs.get(p2)) {  // If the word1 is farther than word2 calculate dist update min if necessary and check the next index of word2
                min = Math.min(min, word1Locs.get(p1) - word2Locs.get(p2));
                p2++;
            } else { // If the word2 is farther than word1 calculate dist update min if necessary and check the next index of word1
                min = Math.min(min, word2Locs.get(p2) - word1Locs.get(p1));
                p1++;
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */