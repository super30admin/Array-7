// Time complexity = O(n)
// Space complexity = O(n), we use n for the map but its a 1 time thing during the initialization, also used n for the lists
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We maintain a hashMap of all the words and the list of its indexes
class WordDistance {
    HashMap<String, List<Integer>> map;

    // itterate over the words and fill the map
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        int i=0;

        for (String word: wordsDict) {
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
            i++;
        }
    }

    // we get the list of indices for both the words and we check for the min distance between them by incrementing the smaller index so that the difference can be minimized
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < l1.size() && idx2 < l2.size()) {
            min = Math.min(min, Math.abs(l1.get(idx1)-l2.get(idx2)));
            if (l1.get(idx1) < l2.get(idx2)) idx1++;
            else idx2++;
        }
        return min;
    }
}