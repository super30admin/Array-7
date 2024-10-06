import java.util.ArrayList;
import java.util.List;

// LC 243
public class ShortestWordDistance_I {
    /**
     * we can have duplicates in the dictionary.
     * but word1 != word2
     * <p>
     * To find the distance, we need indices of word1 and word2.
     * and then, we can choose the min diff.
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> indices1 = new ArrayList<>();
        List<Integer> indices2 = new ArrayList<>();
        for (int index = 0; index < wordsDict.length; index++) {
            String word = wordsDict[index];
            if (word.equals(word1)) {
                indices1.add(index);
            } else if (word.equals(word2)) {
                indices2.add(index);
            }
        }

        /*
        Find min. distance bw 2 sorted arrays

        Use 2 Pointers and move the smallest number pointer.
         */
        int len1 = indices1.size();
        int len2 = indices2.size();
        int p1 = 0, p2 = 0;
        while (p1 < len1 && p2 < len2) {
            int num1 = indices1.get(p1);
            int num2 = indices2.get(p2);
            int diff = Math.abs(num1 - num2);
            min = Math.min(min, diff);
            if (num1 < num2) {
                p1++;
            } else {
                p2++;
            }
        }
        return min;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance_2(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
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
        return min;
    }
}
