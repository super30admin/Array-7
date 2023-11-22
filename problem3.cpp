#include<iostream>
#include<unordered_map>
#include<vector>
#include<string>

using namespace std;

//mine solution

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
    int same_short(vector<string>& wordsDict,string word1){
        int sz = wordsDict.size();
        int slow{sz},fast{sz};
        int max_diff = sz;
        for(int k{};k<sz;++k){
            string word = wordsDict.at(k);
            if(word.compare(word1)==0){
                slow = fast;
                fast = k;
                max_diff = min(max_diff,abs(fast-slow));
            }
        }
        return max_diff;
    }
    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {
        if(word1.compare(word2) != 0){
            return shortestDistance(wordsDict,word1,word2);
        }
        else{
            return same_short(wordsDict,word1);
        }
    }
};

// most optimized solution 
class Solution {
public:
    int shortestWordDistance(vector<string>& words, string word1, string word2) {
        int res = words.size(), l = words.size(), r = -words.size();
        for (unsigned int i=0; i<words.size(); i++) {
            if (words[i] == word1)
                l = (word1==word2)?r:i;
            if (words[i] == word2) 
                r = i;
            res = min(res, abs(l-r));
        }
        return res;
    }
};