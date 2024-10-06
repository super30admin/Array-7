// LC 245
public class ShortestDistance_III {

    /**
     * Same as ShortestWordDistance_I
     * <p>
     * only if we have 2 similar words, I'll use 2 ptrs, curr and prev to find the consecutive difference
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        if (!word1.equals(word2)) {
            for (int index = 0; index < wordsDict.length; index++) {
                String word = wordsDict[index];
                if (word.equals(word1)) {
                    index1 = index;
                } else if (word.equals(word2)) {
                    index2 = index;
                }
                if (index1 > -1 && index2 > -1) {
                    int diff = Math.abs(index1 - index2);
                    min = Math.min(min, diff);
                }
            }
        } else {
            for (int index = 0; index < wordsDict.length; index++) {
                String word = wordsDict[index];
                if (word.equals(word1)) {
//                    if (index2 == -1) {
//                        index2 = index;
//                    } else {
//                        index1 = index2;
//                        index2 = index;
//                    }
                    /*
                    just swap curr and prev pointers
                     */
                    index1 = index2;
                    index2 = index;
                }
                if (index1 > -1) {
                    //  && index2 > -1
                    //  index1 > -1 is possible only when index2 > -1
                    int diff = Math.abs(index1 - index2);
                    min = Math.min(min, diff);
                }
            }
        }
        return min;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance_2(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int index = 0; index < wordsDict.length; index++) {
            String word = wordsDict[index];
            if (word.equals(word1)) {
                index1 = index;
            }
            if (word.equals(word2)) {
                if (index1 == index) {
                    // if word1 == word2
                    index1 = index2;
                    // index2 == current index
                    // index1 == previous index
                    // moving the index1 pointer to the previous pointer
                    // the index2 pointer to current pointer
                }
                index2 = index;
            }

            if (index1 > -1 && index2 > -1) {
                int diff = Math.abs(index1 - index2);
                min = Math.min(min, diff);
            }
        }
        return min;
    }
}
