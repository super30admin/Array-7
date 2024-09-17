// Time Complexity : O(l1 + l2) --> where l1 & l2 are the frequency of input word1 and word2 resp in the input words array
// Space Complexity : O(n) --> where n is the length of the input words array
// Did this code successfully run on Leetcode (244): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class WordDistance {
    Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        int i1 = 0; int i2 = 0;
        int min = Integer.MAX_VALUE;
        while (i1 < li1.size() && i2 < li2.size()) {
            int val1 = li1.get(i1);
            int val2 = li2.get(i2);
            min = Math.min(min, Math.abs(val1 - val2));
            if (val1 < val2) i1++;
            else i2++;
        }
        return min;
    }
}