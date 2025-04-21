
// public class ShortestWordDistance3 {
//     public static int shortestDistance3(String[] wordsDict, String word1, String word2) {
//         if (wordsDict == null || wordsDict.length == 0) {
//             return -1;
//         }
//         int i1 = -1;
//         int i2 = -1;
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < wordsDict.length; i++) {
//             String word = wordsDict[i];
//             if (!word1.equals(word2)) {
//                 if (word.equals(word1)) {
//                     i1 = i;
//                 } else if (word.equals(word2)) {
//                     i2 = i;
//                 }
//             } else {
//                 if (word.equals(word1)) {
//                     i1 = i2;
//                     i2 = i;
//                 }
//             }
//             if (i1 != -1 && i2 != -1) {
//                 min = Math.min(min, Math.abs(i1 - i2));
//             }
//         }
//         return min;
//     }

//     public static void main(String[] args) {
//         String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes", "makes" };
//         System.out.println(shortestDistance3(wordsDict, "makes", "makes"));
//     }
// }

// In this problem, since we have been given that word1 and word2 can be same, but we need to find them present at different index
// position, we will use same i1 and i2 as we did in the first, whenever we find that a word matches word1, we will update i1 to i, 
// then if we find that word2 is also equal to word, we check if i1 is also equal to i, change i1 to i2(give value of i2 to i1) and
// change i2 to i. Then if both not -1, compute difference. 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class ShortestWordDistance3 {
    public static int shortestDistance3(String[] wordsDict, String word1, String word2) {
        // Base case
        if (wordsDict == null || wordsDict.length == 0) {
            return -1;
        }
        // i1 and i2
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        // Loop over wordsDict
        for (int i = 0; i < wordsDict.length; i++) {
            // Take one word at a time
            String word = wordsDict[i];
            // Check if equals word1, make i1 = i
            if (word.equals(word1)) {
                i1 = i;
            }
            // Also check if word2 equals word
            if (word.equals(word2)) {
                // Check if the word1 was also equal
                if (i1 == i) {
                    // Change i1 = i2
                    i1 = i2;
                }
                // and i2=i
                i2 = i;
            }
            // IF both not -1, calc difference
            if (i1 != -1 && i2 != -1) {
                min = Math.min(min, Math.abs(i1 - i2));
            }
        }
        // Return min
        return min;
    }

    public static void main(String[] args) {
        String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes", "makes" };
        System.out.println(shortestDistance3(wordsDict, "makes", "makes"));
    }
}
