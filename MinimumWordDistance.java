import java.util.Arrays;

public class MinimumWordDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1; int p2 = -1;
        int min = wordsDict.length;
        for(int i=0; i<wordsDict.length; i++) { //O(n) T.C, O(1) S.C
            if(wordsDict[i].equals(word1)) p1 = i; //if word1 encountered, update its pointer
            if(wordsDict[i].equals(word2)) p2 = i; //similarly for word2

            if(p1 != -1 && p2 != -1) min = Math.min(min, Math.abs(p1-p2));
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"nithin", "nik", "kumar", "pamidimukkala"};
        String word1 = "nithin";
        String word2 = "kumar";

        System.out.println("The shortest distance between " + word1 + " and " + word2 + " in " +
                Arrays.toString(words) + " is: " + shortestDistance(words, word1, word2));
    }
}
