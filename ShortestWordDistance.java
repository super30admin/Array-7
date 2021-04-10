//TC: O(N)
//SC: O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
         if (wordsDict == null || wordsDict.length < 2)
            return 0;
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++){
           if (wordsDict[i].equals(word1)){
               index1 = i;
           }
           else if (wordsDict[i].equals(word2)){
               index2 = i;
            }
          if (index1 != -1 && index2 != -1){
             minDistance = Math.min(minDistance, Math.abs(index1 - index2));         
           }
        }
    return minDistance;
    }
}
