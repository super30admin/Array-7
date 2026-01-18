// Time Complexity : O(n) + O(k1+k2) - k1, k2 are the list of indexes for word1 and word2
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : As shortest method can be called multiple times, we use a hashmap so that search will be O(1). So we maintain a hashmap to store string
// and it's indexes of occurences. We get the list of indexes of each word and find minimum distance with the help of two pointers.

class WordDistance {

    private Map<String, List<Integer>> map; //hashmap to store string and it's index of occurences

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()) //construct hashmap
                    .add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size()) { //two pointers on list of indices
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);
            min = Math.min(min, Math.abs(idx1 - idx2)); //minimum distance
            if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
