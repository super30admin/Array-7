// Time complexity: O(m+n) where m is the size of indices in 1 and n in indices2 
// Space complexity: O(N) number of words

// Approach : hashmap with 2 pointer to get the result
/*
Hashmap solution is more suitable since we can use the constructor to create the hashmap 

2 pointers to get the final solution

*/

class WordDistance {
public:
    unordered_map<string, vector<int>> dict;
    WordDistance(vector<string>& wordsDict) {
        for(int i = 0; i<wordsDict.size(); i++) {
            dict[wordsDict[i]].push_back(i);
        }
    }
    
    int shortest(string word1, string word2) {
        vector<int> i1 = dict[word1];
        vector<int> i2 = dict[word2];

        int a = 0, b = 0;
        int result = INT_MAX;
        while(a < i1.size() && b < i2.size()) {
            result = min(result, abs(i1[a] - i2[b]));
            if(i1[a] < i2[b])
                a++;
            else
                b++;
        }
        return result;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(wordsDict);
 * int param_1 = obj->shortest(word1,word2);
 */