/*

https://leetcode.com/problems/shortest-word-distance-ii/

Did it run on leetcode: Yes
Did you face any problem: No

Time Compelxity: 0(N)
Space Complexity: 0(N)

Algorithm:
- Create a Map of word and array of index of the word.
- Traverse the positions array of two words and find the minimum pair
- if words are same, find diff with every adjacent index to find minimum


*/



class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i=0;i<words.length;++i){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
        
        if(word1.equals(word2)){
            
            Integer[] pos = new Integer[map.get(word1).size()];
            pos = map.get(word1).toArray(pos);
            int min = pos[1]-pos[0];
            for(int i=2;i<pos.length;++i){
                min = Math.min(min,pos[i]-pos[i-1]);
            }
            return min;
        }else{
            
            Integer[] loc1 = new Integer[map.get(word1).size()];
            loc1 = map.get(word1).toArray(loc1);
            
            Integer[] loc2 = new Integer[map.get(word2).size()];
            loc2 = map.get(word2).toArray(loc2);
            
            int i=0,j=0;
            int min = Integer.MAX_VALUE;
            
            while(i<loc1.length && j<loc2.length){
                min = Math.min(min,Math.abs(loc1[i]-loc2[j]));
                if(loc1[i]<loc2[j]){
                    i=i+1;
                }else{
                    j=j+1;
                }
            }
            return min;
        }
        
    }
}