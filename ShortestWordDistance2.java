/**
 * Preprocesses wordsDict into a map from word to sorted index positions.
 * Uses two-pointer traversal over index lists to compute minimum distance efficiently.
 * Time Complexity: O(N + Q), Space Complexity: O(N)
 */
public class ShortestWordDistance2 {
    Map<String, List<Integer>> hmap;

    public WordDistance(String[] wordsDict) {
        hmap = new HashMap<>();

        for(int i = 0; i <wordsDict.length ; i++) {
            hmap.putIfAbsent(wordsDict[i], new ArrayList<Integer>());
            hmap.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int  minDiff = Integer.MAX_VALUE;
        List<Integer> loc1 = hmap.get(word1);
        List<Integer> loc2 = hmap.get(word2);

        int idx1 = 0;
        int idx2 = 0; 

        while(idx1 < loc1.size() && idx2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(idx1) - loc2.get(idx2)));

            if(loc1.get(idx1) < loc2.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return minDiff;
    }    
}
