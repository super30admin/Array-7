TC: O(n)
SC: O(1)

Runtime: 1 ms, faster than 99.92% of Java online submissions for Shortest Word Distance.
Memory Usage: 42.8 MB, less than 7.14% of Java online submissions for Shortest Word Distance.

Approach: Declare a global minimum distance to int max.When found a valid pair of word1 and word2 as we traverse the array, find the absolute
distance between them and update the global minimum appropriately.

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int min_distance = Integer.MAX_VALUE;
        
        int i1= -1; 
        int i2= -1;
        
        for(int i=0 ; i<words.length; i++){
            if(words[i].equals(word1)) i1=i;
            
            if(words[i].equals(word2)) i2=i;
            
            int diff = Math.abs(i1-i2);
            if(i1!= -1 && i2!= -1){
                if(diff < min_distance) min_distance = diff;    
            }
            
        }
        
        return min_distance;
        
        
    }
}
