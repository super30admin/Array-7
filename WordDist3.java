// 245.
// time - O(n)
// space - constant
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        //edge
        if(words == null || words.length == 0)
        {
            return 0;
        }
        int i1 = -1; //i1 and i2 tracks the current occurence of word1 and word2
        int i2 = -1;
        int result = Integer.MAX_VALUE; //return value
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].equals(word1))
            {
                i1 = i;
            }
            if(words[i].equals(word2))
            {
                //if both word1 and word2 equal, so make i2 = i1 to restore last occurence of word1 into i2 and update i1 
                if(word1.equals(word2))
                {
                    i1 = i2;
                }       
                i2 = i;
            }
            if(i1 != -1 && i2 != -1)
            {
                //valid pair found - find dist and update result
                result = Math.min(result, Math.abs(i2 - i1));
            }
        }
        return result;
    }
}
