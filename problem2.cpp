/*
// Time Complexity : O(N) for each call
// Space Complexity : O(N) number of words.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<unordered_map>
#include<vector>
#include<string>

using namespace std;

class WordDistance {
public:
    unordered_map<string,vector<int>> umap{};
    size_t max_size{};
    WordDistance(vector<string>& wordsDict) {
        this->max_size = wordsDict.size();
        for(int i{};i<this->max_size;++i){
            string word = wordsDict.at(i);
            if(umap.find(word) == umap.end()){
                this->umap[word] = vector<int>{};
            }
            this->umap[word].push_back(i);
        }
    }
    
    int shortest(string word1, string word2) {
        int i{},j{};
        size_t w1_sz{},w2_sz{};
        w1_sz = this->umap[word1].size();
        w2_sz = this->umap[word2].size();
        int max_diff = this->max_size;
        while(i<w1_sz && j<w2_sz){
            int val = abs(this->umap[word1].at(i) - this->umap[word2].at(j));
            max_diff = min(max_diff,val);
            if(this->umap[word1].at(i)<this->umap[word2].at(j)){
                ++i;
            }
            else if(this->umap[word1].at(i)>this->umap[word2].at(j)){
                ++j;
            }
        }
        while(i<w1_sz){
            int val = abs(this->umap[word1].at(i)-this->umap[word2].at(j-1));
            max_diff = min(max_diff,val);
            ++i;
        }
        while(j<w2_sz){
            int val = abs(this->umap[word1].at(i-1)-this->umap[word2].at(j));
            max_diff = min(max_diff,val);
            ++j;
        }
        return max_diff;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(wordsDict);
 * int param_1 = obj->shortest(word1,word2);
 */