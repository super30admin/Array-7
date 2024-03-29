class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        if(wordsDict == null || wordsDict.length == 0) return 0;

        int index1, index2;
        index1 = index2 = -1;

        int minimum = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++)
        {
            if(wordsDict[i].equals(word1)) index1 = i;

            else if(wordsDict[i].equals(word2)) index2 = i;

            if(index1 != -1 && index2 != -1) minimum = Math.min(minimum, (int)Math.abs(index2 - index1));
        }

        return minimum;
    }
}