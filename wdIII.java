//Time Complexity:O(n) to scan wordsDict, O(k1 + k2) for two pointers.
//Space Complexity: O(n) — storing indices of each word in the map.

//Build map: word -> sorted list of indices via a single pass over wordsDict.
//If word1 == word2, scan its index list and take the minimum gap between consecutive indices.
//Else, run a two-pointer merge over the two lists, updating the min absolute difference and advancing the smaller index.

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        int n = wordsDict.length;

        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }

        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;

        if(word1.equals(word2)) {
            for(int i = 1; i < word1List.size(); i++) {
                min = Math.min(min, word1List.get(i) - word1List.get(i - 1));
            }
            return min;
        } else {
            while(p1 < word1List.size() && p2 < word2List.size()) {
                if(word1List.get(p1) < word2List.get(p2)) {
                    min = Math.min(min, word2List.get(p2) - word1List.get(p1));
                    p1++;
                } else {
                    min = Math.min(min, word1List.get(p1) - word2List.get(p2));
                    p2++;
                }
            }
            return min;
        }
    }
}
