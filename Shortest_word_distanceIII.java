//TC O(N)
//SC O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
     int minDistance = Integer.MAX_VALUE;
     int i2 = -1, i1 = -1;
     for(int i = 0; i< wordsDict.length; i++){
         if(wordsDict[i].equals(word1)) i1 = i;
         
         if(wordsDict[i].equals(word2)) {
            if(word1.equals(word2)){
                i1 = i2;
            }       
             i2 = i;}
         
         if(i1 != -1 && i2 != -1){
             minDistance = Math.min(minDistance, Math.abs(i1 - i2));
         }
     }
        
        return minDistance;
    }
}