class Solution{


//Time Complexity: O(n)
//Space Complexity: O(1)
// we go through the list once and track the last options of word1 and word2
// Everytime we find both, we calculate and update the minimum distance
//This avoids nested loops and gives us the shortest distance efficiently
    public int shortestDistance(String[] wordsDict, String wordString, String wordString2)
    {
        int n = wordsDict.length;

        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            String word = wordsDict[i];

            if(word.equals(word1))
            {
                p1 = i;
            }

            if(word.equals(word2))
            {
                p2 = i;
            }

            if(p1 != -1 && p2 != -1)
            {
                min = Math.min(min,Math.abs(p1-p2));
            }
        }
        return min;
    }
}