public class WordDistance {
    //TC: O(m+k)
    //Sc: O(n)
    HashMap<String, List<Integer>> map;
    public WordDistance(List<String> wordsDict) {
        this.map = new HashMap<>();
        for(int i = 0; i < wordsDict.size(); i++){
            String currWord = wordsDict.get(i);
            if(!map.containsKey(currWord)){
                map.put(currWord, new ArrayList<>());
            }
            map.get(currWord).add(i);
        }
    }

    /**
     * @param word1: word1
     * @param word2: word2
     * @return: the shortest distance between two words
     */
    public int shortest(String word1, String word2) {
        // write your code here
        int min = Integer.MAX_VALUE;
        List<Integer> listW1 = map.get(word1);
        List<Integer> listW2 = map.get(word2);
        int p1 = 0, p2 = 0;
        while(p1 < listW1.size() && p2 < listW2.size()){
            int val1 = listW1.get(p1);
            int val2 = listW2.get(p2);
            min = Math.min(min, Math.abs(val1-val2));
            if(val1 < val2) p1++;
            else p2++;
        }
        return min;
    }
}
