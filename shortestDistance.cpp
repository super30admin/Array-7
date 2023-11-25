// Approach 1: Hashmap appraoch
// Time complexity: O(n)
// Space complexity: O(n) - for the hashmap

class Solution {
public:
    int shortestDistance(vector<string>& wordsDict, string word1, string word2) {
        if(wordsDict.size() == 0)
            return 0;
        int result = INT_MAX, index1, index2;
        unordered_map<string, vector<int>> map;
        for(int i =0; i<wordsDict.size(); i++) {
            map[wordsDict[i]].push_back(i);
        }
        vector<int> indices1 = map[word1];
        vector<int> indices2 = map[word2];
        int a=0, b=0;
        while(a < indices1.size() && b<indices2.size()) {
            result = min(result, abs(indices1[a]-indices2[b]));
            if(indices1[a]<indices2[b])
                a++;
            else
                b++;
        }
        return result;
    }
};

// Approach 2: 2 pointer 
// Time complexity: O(n)
// Space complexity: O(1) 

class Solution {
public:
    int shortestDistance(vector<string>& wordsDict, string word1, string word2) {
        if(wordsDict.size() == 0)
            return 0;
        int result = INT_MAX;
        int index1 = -1;
        int index2 = -1;

        // the word can either be word1 or word2 -> when we have found both - just calculate the minimum distance 
        for(int i = 0; i<wordsDict.size(); i++) {
            // find word1
            if(wordsDict[i] == word1)
                index1 = i;
            // find word2
            else if(wordsDict[i] == word2)
                index2 = i;
            // calculate the diff when you find both word1 and word2
            if(index1 != -1 && index2 != -1) {
                result = min(result, abs(index1-index2));
            }
        }
        return result;
    }
};