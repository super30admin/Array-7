import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumWordDistance2 {
    HashMap<String, List<Integer>> map;

    public MinimumWordDistance2(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) { //O(n) T.C
            String word = wordsDict[i];
            if(!map.containsKey(word)) map.put(word, new ArrayList<>());
            map.get(word).add(i); //O(n) S.C
        }
    }

    public int shortest(String word1, String word2) { //O(l1+l2) T.C
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        int p1 = 0; int p2 = 0;

        while(p1 < l1.size() && p2 < l2.size()) {
            min = Math.min(min, Math.abs(l1.get(p1) - l2.get(p2)));
            if(l1.get(p1) < l2.get(p2)) p1++;
            else p2++;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"nithin", "nik", "kumar", "pamidimukkala"};
        MinimumWordDistance2 minimumWordDistance2 = new MinimumWordDistance2(words);

        String word1 = "nithin";
        String word2 = "kumar";

        System.out.println("The shortest distance between " + word1 + " and " + word2 + " in " +
                Arrays.toString(words) + " is: " + minimumWordDistance2.shortest(word1, word2));

        String word3 = "pamidimukkala";

        System.out.println("The shortest distance between " + word1 + " and " + word3 + " in " +
                Arrays.toString(words) + " is: " + minimumWordDistance2.shortest(word1, word3));
    }
}
