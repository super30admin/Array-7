/*
Solved by Sahil
TC :  O(m+n)
SC : O(n)
*/
class WordDistance
{
public:
    map<string, vector<int>> hashmap;
    WordDistance(vector<string> &wordsDict)
    {
        if (wordsDict.size() == 0)
        {
            return;
        }

        for (int i = 0; i < wordsDict.size(); i++)
        {
            hashmap[wordsDict[i]].push_back(i);
        }
    }

    int shortest(string word1, string word2)
    {
        vector<int> w1 = hashmap[word1];
        vector<int> w2 = hashmap[word2];

        int p1 = 0, p2 = 0;
        int minPath = INT_MAX;

        int m = w1.size();
        int n = w2.size();
        while (p1 < m && p2 < n)
        {
            minPath = min(minPath, abs(w1[p1] - w2[p2]));
            if (w1[p1] < w2[p2])
            {
                p1++;
            }
            else
            {
                p2++;
            }
        }
        return minPath;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(wordsDict);
 * int param_1 = obj->shortest(word1,word2);
 */