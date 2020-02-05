/*

https://leetcode.com/problems/shortest-word-distance-ii/

Did it run on leetcode: Yes
Did you face any problem: No

Time Compelxity: 0(N)
Space Complexity: 0(N)

Algorithm:
- Create a Map of word and array of index of the word.
- Traverse the positions array of two words and find the minimum pair



*/


class WordDistance {

    Map<String,List<Integer>> map;
    public WordDistance(String[] words) {
        
        map = new HashMap<>();
        
        for(int i=0;i<words.length;++i){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        
       
        int min = Integer.MAX_VALUE;
        for(Integer i: map.get(word1)){
            for(Integer j: map.get(word2)){
                min = Math.min(min,Math.abs(i-j));
            }
        }
        
        return min;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */