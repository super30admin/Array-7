
// Time Complexity : O(nk) where n is the length of wordsDict and k is the average length of each word(time taken to compare words)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain two variables i1 and i2 and set them to -1 initially. I loop through the wordsDict and whenever I find a word that equals
to word1, I update i1 and similarly if I find a word that equals word2 I update i2. If both i1 and i2 are not equal to -1, I 
calculate the absolute value of the difference between them and return the least value of the difference obtained.
*/

public class Solution
{
    public int ShortestDistance(string[] wordsDict, string word1, string word2)
    {
        int i1 = -1, i2 = -1;
        int result = Int32.MaxValue;

        for (int i = 0; i < wordsDict.Length; i++)
        {
            string word = wordsDict[i];
            if (word == word1)
            {
                i1 = i;
            }

            else if (word == word2)
            {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1)
            {
                result = Math.Min(result, Math.Abs(i1 - i2));
            }
        }

        return result;
    }
}