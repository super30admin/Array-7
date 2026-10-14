/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(n) where n is the length of the array
 */
class WordDistance {
    Map<String, List<Integer>> wordToIndex;

    public WordDistance(String[] wordsDict) {
        this.wordToIndex = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            wordToIndex.putIfAbsent(wordsDict[i], new ArrayList<>());
            wordToIndex.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indicesOfWord1 = wordToIndex.get(word1);
        List<Integer> indicesOfWord2 = wordToIndex.get(word2);

        //Case 1 - indices do not overlap
        int firstOccWord1 = indicesOfWord1.get(0);
        int firstOccWord2 = indicesOfWord2.get(0);
        int lastOccWord1 = indicesOfWord1.get(indicesOfWord1.size() - 1);
        int lastOccWord2 = indicesOfWord2.get(indicesOfWord2.size() - 1);

        if (lastOccWord1 < firstOccWord2) {
            return firstOccWord2 - lastOccWord1;
        }
        if (lastOccWord2 < firstOccWord1) {
            return firstOccWord1 - lastOccWord2;
        }

        //Case 2 - indices overlap

        int ptr1 = 0;
        int ptr2 = 0;
        int result = Integer.MAX_VALUE;

        while (ptr1 < indicesOfWord1.size() && ptr2 < indicesOfWord2.size()) {
            result = Math.min(result, Math.abs(indicesOfWord1.get(ptr1) - indicesOfWord2.get(ptr2)));

            if (indicesOfWord1.get(ptr1) < indicesOfWord2.get(ptr2)) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        return result;

    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */