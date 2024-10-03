/*
**Time Complexity (TC):**
- `WordDistance(vector<string>& wordsDict)`: O(N)
- `shortest(string word1, string word2)`: O(N)

**Space Complexity (SC):** O(N)

Where:
- `N` is the number of elements in the `wordsDict` array.
*/

class WordDistance {
public:
    map<string, vector<int>> mp;
    WordDistance(vector<string>& wordsDict) {
        for(int i=0;i<wordsDict.size();i++) {
            string word = wordsDict[i];
            mp[word].push_back(i);
        }
    }
    
    int shortest(string word1, string word2) {
        int len1=mp[word1].size();
        int len2=mp[word2].size();
        vector<int> v1 = mp[word1];
        vector<int> v2 = mp[word2];
        int i=0,j=0;
        int dist = INT_MAX;
        while(i<len1 && j<len2) {
            if(v1[i] > v2[j]) {
                dist = min(dist, v1[i]-v2[j]);
                j++;
            } else if(v1[i] < v2[j]) {
                dist = min(dist, v2[j]-v1[i]);
                i++;
            } else {
                return 0;
            }
        }
        return dist;
    }
};