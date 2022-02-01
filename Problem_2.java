// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Take a hashmap to store the string to the index of both the word, and then traverse through the list of index of both words and get the min distance between the both
// Your code here along with comments explaining your approach
class WordDistance {

    HashMap<String, ArrayList<Integer>> hm;
    public WordDistance(String[] wordsDict) {
        hm = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            if(!hm.containsKey(wordsDict[i])){
                hm.put(wordsDict[i], new ArrayList<>());
            }
            hm.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> a1 = hm.get(word1);
        ArrayList<Integer> a2 = hm.get(word2);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(i < a1.size() && j < a2.size()){
            min = Math.min(min, Math.abs(a1.get(i)-a2.get(j)));
            if(a1.get(i) < a2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */