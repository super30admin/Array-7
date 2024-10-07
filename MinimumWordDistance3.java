import java.util.Arrays;

public class MinimumWordDistance3 {
    public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1; int p2 = -1;
        int min = wordsDict.length;
        for(int i = 0; i < wordsDict.length; i++) { //O(n) T.C, O(1) S.C
            String word = wordsDict[i];
            if(word.equals(word1)) p1 = i; //word1 encountered, update pointer1
            if(word.equals(word2)) { //word2 encountered
                if(p1 == i) p1 = p2; //if word1 is also same, move p1 to p2 (prev -> curr)
                p2 = i; //update pointer2 (curr -> curr.next)
            }
            if(p1 != -1 && p2 != -1) min = Math.min(min, Math.abs(p1 - p2));
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"nithin", "nik", "kumar", "pamidimukkala", "nik"};
        String word1 = "nik";
        String word2 = "nik";

        System.out.println("The shortest distance between " + word1 + " and " + word2 + " in " +
                Arrays.toString(words) + " is: " + shortestWordDistance(words, word1, word2));
    }
}
