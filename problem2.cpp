// Time Complexity : O(N) ,N= wordsDict.size()  ==> for all queries, atMax we traverse O(N) times
// Space Complexity :O(N)  for map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach:  2-pointers approach


class WordDistance {
public:
    unordered_map<string,vector<int>>map;
    WordDistance(vector<string>& wordsDict) {
        for(int i = 0;i<wordsDict.size();i++)
        {
            string &word = wordsDict[i];
            if(map.find(word)==map.end()){
                map.insert({word,vector<int>()});
            }
            map[word].push_back(i);
        }
    }
    
    int shortest(string word1, string word2) {
        vector<int>&list1 = map[word1];
        vector<int>&list2 = map[word2];
        
        int i1 = 0,i2 = 0;
        int ans = INT_MAX;
        
        while(i1<list1.size() && i2<list2.size())
        {
            ans = min(ans,abs(list1[i1]-list2[i2]));
            if(list1[i1]<list2[i2]){
                i1++;
            }
            else{
                i2++;
            }
        }
        return ans;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(wordsDict);
 * int param_1 = obj->shortest(word1,word2);
 */