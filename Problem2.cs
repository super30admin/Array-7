// Time Complexity : O(n) to build the hashmap in the constructor (happens once) + O(a + b) where a is the number of occurrences of word1 
// and b is the number of occurrences of word2
// Space Complexity : O(n) to store the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I build a hash map where each distinct word in `wordsDict` is stored as a key, and its corresponding indices are stored as a list of integers.
In the `Shortest` function, I retrieve the index lists for both words from the hash map. 
I then use two pointers, starting at the first index of each list, and calculate the absolute difference between the two indices. 
I store the minimum absolute difference found so far in a `result` variable. 
At each step, I increment the pointer corresponding to the smaller index, since moving past the smaller index may result in a smaller difference.
I then return th minimum absolute difference.
*/

public class WordDistance
{
    private Dictionary<string, List<int>> indexMap;

    public WordDistance(string[] wordsDict)
    {
        indexMap = new();

        for (int i = 0; i < wordsDict.Length; i++)
        {
            string word = wordsDict[i];

            if (!indexMap.ContainsKey(word))
            {
                indexMap[word] = new List<int>();
            }

            indexMap[word].Add(i);
        }
    }

    public int Shortest(string word1, string word2)
    {
        List<int> l1 = indexMap[word1];
        List<int> l2 = indexMap[word2];
        int result = Int32.MaxValue;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < l1.Count && idx2 < l2.Count)
        {
            result = Math.Min(result, Math.Abs(l1[idx1] - l2[idx2]));

            if (l1[idx1] < l2[idx2])
            {
                idx1++;
            }

            else
            {
                idx2++;
            }

        }

        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.Shortest(word1,word2);
 */