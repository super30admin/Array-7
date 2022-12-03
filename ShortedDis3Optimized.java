class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        //tc-o(nk) sc-o(1)
        if(wordsDict == null) return 0;
        int min = Integer.MAX_VALUE;
        int i1=-1,i2=-1;
        for(int i=0;i<wordsDict.length;i++)
        {   
        if(wordsDict[i].equals(word1))
        {
            i1=i;
        }
        if(wordsDict[i].equals(word2))
        {
            if(i1==i)
            {
                i1=i2;
            }
            i2=i;
        }
        if(i1!=-1 && i2!= -1)
        {
            min = Math.min(min,Math.abs(i1-i2));
        }
        }
        return min;

    }
}