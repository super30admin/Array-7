//time complexity: O(n)
//space complexity: O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1=-1;
        int p2=-1;
        int max=Integer.MAX_VALUE;
        if(word1.equals(word2))
        {
            for(int i=0;i<wordsDict.length;i++)
            {
                if(wordsDict[i].equals(word1))
                {
                    if(p1>p2)
                        p2=i;
                    else
                        p1=i;
                }
                if(p1!=-1 && p2!=-1)
                    max=Math.min(max,Math.abs(p2-p1));
            }
        }
        else
        {
            for(int i=0;i<wordsDict.length;i++)
            {
                if(wordsDict[i].equals(word1)){
                    p1=i;
                }
                if(wordsDict[i].equals(word2)){
                    p2=i;
                }
                if(p1!=-1 && p2!=-1)
                    max=Math.min(Math.abs(p2-p1),max);
            }
        }
        return max;
    }
}