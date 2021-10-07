# Array-8

## Problem 1: Minimum word distance (https://leetcode.com/problems/shortest-word-distance/)

//Time complexity = O(N)
//Space complexity = O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1; 
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                p1 = i;
            }
            if(wordsDict[i].equals(word2)){
                p2 = i;
            }
            
            if(p1 != -1 && p2 != -1){
                min = Math.min(min, Math.abs(p2 - p1)); 
            }
        }
        
        return min; 
    }
}

## Problem 2: Minimum word distance ii (https://leetcode.com/problems/shortest-word-distance-ii/)

//Time complexity = O(N)
//Space complexity = O(N)
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap(); 
        
        for(int i = 0; i < wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>()); 
            }
            map.get(wordsDict[i]).add(i); 
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1); 
        List<Integer> l2 = map.get(word2); 
        int min = Integer.MAX_VALUE; 
        
        int p1 = 0; 
        int p2 = 0; 
        
        while(p1 < l1.size() && p2 < l2.size()){
            int index1 = l1.get(p1); 
            int index2 = l2.get(p2); 
            
            min = Math.min(min,Math.abs(index1 - index2));
            
            if(index1 <= index2) p1++;
            else if(index2 < index1) p2++;
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */

## Problem 3: Minimum word distance iii (https://leetcode.com/problems/shortest-word-distance-iii/)

//Time complexity = O(N)
//Space complexity = O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            String curr = wordsDict[i]; 
            if(curr.equals(word1)){
                i1 = i; 
            }
            
            if(curr.equals(word2)){
                if(i1 == i){
                    i1 = i2; 
                }
                i2 = i; 
            }
            if(i2 != -1 && i1 != -1) min = Math.min(min, Math.abs(i2 - i1)); 
        }
        
        return min;
    }
}
