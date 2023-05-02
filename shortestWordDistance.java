// Time complexity : O(n)
// Space complexity : O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
       int p1 = -1, p2 = -1;

       int min = Integer.MAX_VALUE;
       for(int i = 0 ; i < wordsDict.length; i++)
       {
           String curr = wordsDict[i];
           if(curr.equals(word1))
           {
               p1 = i;
           }
           if(curr.equals(word2))
           {
               p2 = i;
           }

           if(p1 != -1 && p2 != -1)
           {
               min = Math.min(min, Math.abs(p2-p1));
           }

           
       } 
       return min;
    }
}