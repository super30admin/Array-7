//TC: O(N)
//SC: O(1)
//Did it run successfully on Leetcode?:Yes
//line 11,14,15 conditions are the only small variations of Shortest Word Distance problem
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length < 2)
            return 0;
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean same = word1.equals(word2)? true: false;
        for (int i = 0; i < wordsDict.length; i++){
           if (wordsDict[i].equals(word1)){
               if (same){
                   index2 = index1;
               }
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
