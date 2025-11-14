public class MinimumWordDistanceIII {

    //Time Complexity:O(n)
    //Space Complexity:O(1)
//We loop through the words and update p1 and p2 whenever we see word1 or word2.
//If both words are the same, the trick if(p1 == i) p1 = p2; ensures we alternate p1 and p2.
//Once both positions are valid, we update the minimum distance.
    public int shortestWordDistance(String[] wordsDict, String word1, String word2)
    {
        int n = wordsDict.length;
        int p1 = -1 , p2 = -1;
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
                if(p1==i)
                {
                    p1 = p2;
                }
                p2 = i;

            }

            if(p1 != -1 && p2 != -1)
            {
                min = Math.min(min, Math.abs(p1-p2));
            }
        }

        return min;
    }
}
