//Time: O(n)
//Space: O(1)
//Program ran on leetcode successfully

class shortestDist2 {
    private HashMap<String, ArrayList<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> p1 = map.get(word1);
        List<Integer> p2 = map.get(word2);
        if (p1 == null || p2 == null) {
            return -1;
        }
        int shortest = Integer.MAX_VALUE;
        int i1 = 0;
        int i2 = 0;
        while (i1 < p1.size() && i2 < p2.size()) {
            shortest = Math.min(Math.abs(p1.get(i1) - p2.get(i2)), shortest);
            if (p1.get(i1) < p2.get(i2)) {
                i1++;
            } else {
                i2++;
            }
        }
        return shortest;
    }
}