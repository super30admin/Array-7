class Solution{
  
    //Time Complexity: O(n)
    //Space Complexity: O(1)

      public  int shortestWordDistanceI(String[] words, String word1, String word2){
        
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<words.length; i++){
            
            String word = words[i];
            
            if(word.equals(word1)){
                i1 = i;
            }
            if(word.equals(word2)){
                i2 = i;
            }
            
            if(i1 != -1 && i2 != -1){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }
        return min;   
    }

}
