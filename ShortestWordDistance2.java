// Time Complexity : O(n*l) for cons, O(k) for shortest => k - avg occurence of each word
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Iterate over each word and add index of found word to a Hashmap of word and its indices
// Iterate over the list of indices, find min and update the next of smaller index

class Solution {

    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(!map.containsKey(wordsDict[i]))
                map.put(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> w1 = map.getOrDefault(word1, new ArrayList<>());
        List<Integer> w2 = map.getOrDefault(word2, new ArrayList<>());

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while (i < w1.size() && j < w2.size()) {
            min = Math.min(min, Math.abs(w1.get(i) - w2.get(j)));
            if (w1.get(i) < w2.get(j))
                i++;
            else
                j++;
        }

        return min;

    }
}
