/*
Solved by Sahil
TC : O(n)
SC : O(1)
*/
class Solution
{
public:
    int shortestDistance(vector<string> &wordsDict, string word1, string word2)
    {
        if (word1.size() == 0 || word2.size() == 0)
        {
            return 0;
        }

        int w1 = -1, w2 = -1;
        int minPath = INT_MAX;

        for (int i = 0; i < wordsDict.size(); i++)
        {
            if (word1 == wordsDict[i])
            {
                w1 = i;
            }
            if (word2 == wordsDict[i])
            {
                w2 = i;
            }
            if (w1 != -1 && w2 != -1)
            {
                minPath = min(minPath, abs(w1 - w2));
            }
        }

        return minPath;
    }
};