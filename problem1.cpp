/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Finding all index where they occur and using idea of traversing pointers when joining two linked list
which are ordered in monotonic increasing manner.
*/


#include<iostream>
#include<vector>

using namespace std;


class Solution {
public:

    int shortestDistance(vector<string>& wordsDict, string word1, string word2){
        vector<int> w1{};
        vector<int> w2{};
        size_t sz = wordsDict.size();
        for(int i{};i<sz;++i){
            string w = wordsDict.at(i);
            if(word1.compare(w) == 0){
                w1.push_back(i);
            }
            if(word2.compare(w) == 0){
                w2.push_back(i);
            }
        }
        int i{},j{};
        size_t w1_sz{},w2_sz{};
        w1_sz = w1.size();w2_sz = w2.size();
        int max_diff = sz;
        while(i<w1_sz && j<w2_sz){
            int val = abs(w1.at(i) - w2.at(j));
            max_diff = min(max_diff,val);
            if(w1.at(i)<w2.at(j)){
                ++i;
            }
            else if(w1.at(i)>w2.at(j)){
                ++j;
            }
        }
        while(i<w1_sz){
            int val = abs(w1.at(i)-w2.at(j-1));
            max_diff = min(max_diff,val);
            ++i;
        }
        while(j<w2_sz){
            int val = abs(w1.at(i-1)-w2.at(j));
            max_diff = min(max_diff,val);
            ++j;
        }
        return max_diff;
    }
};