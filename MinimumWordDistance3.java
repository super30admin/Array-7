class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if(word1.equals(word2))
        {
            boolean first= true;
            int i1=-1, i2=-1, min=Integer.MAX_VALUE;
            for(int i =0;i<wordsDict.length;i++)
            {
                String s =wordsDict[i];
                if(s.equals(word1))
                {
                    if(first)
                    {
                        first= false;
                        i1=i;
                    }
                    else{
                        first= true;
                        i2=i;
                    }
                    
                    
                }
                if(i1!=-1 && i2!=-1)
                {
                    min = Math.min(min, Math.abs(i1-i2));
                }
            }
            
            return min;
        }
     else
     {
       int i1 =-1, i2=-1, min = Integer.MAX_VALUE;
         for(int i =0; i<wordsDict.length;i++)
         {
             
             String s = wordsDict[i];
             if(s.equals(word1))
                 i1=i;
             else if(s.equals(word2))
                 i2=i;
             if(i1!=-1 && i2!=-1)
                 min = Math.min(min, Math.abs(i2-i1));
         }
         return min;
         
     }
    }
}