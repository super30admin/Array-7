// TC: O(n)
// SC: O(n)

class WordDistance {
    HashMap<String, List<Integer>> map;
    int n;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        this.n = wordsDict.length;

        for(int i=0; i<n; i++){
            String curr = wordsDict[i];

            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;

        while(p1<li1.size() && p2<li2.size()){

            if(li1.get(p1) < li2.get(p2)){
                min = Math.min(min, li2.get(p2) - li1.get(p1));
                p1++;
            }else{
                min = Math.min(min, li1.get(p1) - li2.get(p2));
                p2++;
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1, word2);
 */
