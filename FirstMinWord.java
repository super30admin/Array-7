import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstMinWord {
    // Approach 1
    // TC : O(n * k) n - number of words   k - average length of the word
    // SC : O(1)
    public int shortestDistance(String[] wordDict, String word1, String word2) {
        if(wordDict == null || wordDict.length == 0) return 0;

        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < wordDict.length;i++) {
            if(wordDict[i].equals(word1)){
                i1 = i;
            }

            if(wordDict[i].equals(word2)) {
                i2 = i;
            }
            min = Math.min(min, Math.abs(i1 - i2));
        }

        return min;
    }

    // Approach 2
    // In above approach if we get different set of words: word1 & word2 then we will need to iterate the whole array again
    // TC : O((m + n) + (n * k))
        // m - list1.length
        // n - list2.length
        // equals method matches every character so n * k
    // SC : O(n)
    public int shortestDistance2(String[] wordDict, String word1, String word2) {
        if(wordDict == null || wordDict.length == 0) return 0;

        int min = Integer.MAX_VALUE;

        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i < wordDict.length;i++) {
            String word = wordDict[i];
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int p1 = 0;
        int p2 = 0;

        while(p1 < list1.size() && p2 < list2.size()) {
            int idx1 = list1.get(p1);
            int idx2 = list2.get(p2);

            min = Math.min(min, Math.abs(idx1 - idx2));
            if(idx1 < idx2) p1++;
            else p2++;
        }

        return min;
    }
}
