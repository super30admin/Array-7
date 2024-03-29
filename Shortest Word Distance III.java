class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        
        if(wordsDict == null || wordsDict.length == 0) return 0;

        int index1, index2;
        index1 = index2 = -1;

        int minimum = Integer.MAX_VALUE;

        // This is shortest word distance I code
        if(!word1.equals(word2))
        {
            for(int i = 0; i < wordsDict.length; i++)
            {
                if(wordsDict[i].equals(word1)) index1 = i;

                else if(wordsDict[i].equals(word2)) index2 = i;

                if(index1 != -1 && index2 != -1) minimum = Math.min(minimum, (int)Math.abs(index2 - index1));
            }
        }

        else
        {
            for(int i = 0; i < wordsDict.length; i++)
            {
                // Both the word1 and word2 are equal thats why we came to the else block
                if(wordsDict[i].equals(word1))
                {
                    // We always have to update the minimum index to i this is bcoz the distance would be minimum when we maximise 
                    // the minimum index
                    if(index1 < index2) index1 = i;

                    else index2 = i;
                }

                if(index1 != -1 && index2 != -1) minimum = Math.min(minimum, (int)Math.abs(index2 - index1));
            }
        }

        return minimum;
    }
}