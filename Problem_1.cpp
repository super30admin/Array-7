243. Shortest Word Distance

TC O(n)
SC O(n)

class Solution {
public:
    int shortestDistance(vector<string>& wordsDict, string word1, string word2) {
        unordered_map<string, vector<int>> idx;
        for (int i = 0; i < wordsDict.size(); ++i) {
            idx[wordsDict[i]].push_back(i);
        }
        
        const auto& l1 = idx[word1];
        const auto& l2 = idx[word2];
        
        int minD = std::numeric_limits<int>::max();
        
        int i = 0; int j = 0;
        for (int k = 0; k < l1.size() + l2.size(); ++k) {
            int v1 = i < l1.size() ? l1[i] : l1[l1.size() - 1];
            int v2 = j < l2.size() ? l2[j] : l2[l2.size() - 1];
            
            int d = 0;
            if (v1 < v2) {
                d = v2 - v1;
                ++i;
            }
            else {
                d = v1 - v2;
                ++j;
            }
            minD = min(minD, d);
        }
        
        return minD;
    }
};
