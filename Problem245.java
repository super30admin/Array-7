package problems.arrays;

import problems.string.Problem791;
//TC=O(n)
//SC=O(1)
public class Problem245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1))
                p1 = i;
            if (word.equals(word2)) {
                if (p1 == i)
                    p1 = p2;
                p2 = i;
            }
            if (p1 != -1 && p2 != -1)
                diff = Math.min(diff, Math.abs(p1 - p2));
        }
        return diff;
    }

    public static void main(String[] args) {
        Problem245 problem=new Problem245();
        String[] wordDict=new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(problem.shortestWordDistance(wordDict,"makes","makes"));
        System.out.println(problem.shortestWordDistance(wordDict,"practice","coding"));
    }
}
