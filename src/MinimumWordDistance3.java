//time complexity- O(n)
//space complexity- O(1)
public class MinimumWordDistance3 {
    static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];
            if(word1.equals(word2)) {
                if(word.equals(word1)) {
                    if(p1 <= p2) {
                        p1 = i;
                    } else {
                        p2 = i;
                    }
                }
            } else {
                if(word.equals(word1)) {
                    p1 = i;
                }
                if(word.equals(word2)) {
                    p2 = i;
                }
            }
            if(p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes", word2 = "coding";
        System.out.println("Minimum word distance: "+ shortestWordDistance(wordsDict, word1, word2));
    }
}
