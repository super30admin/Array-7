// Time Complexity : O(N) ,N= wordsDict.size()
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach : 2 pointers

class Solution {
public:
    int shortestDistance(vector<string>& wordsDict, string word1, string word2) {
        int i1 = -1,i2 = -1;
        int ans = INT_MAX;
        
        for(int i = 0;i<wordsDict.size();i++)
        {
            string &word = wordsDict[i];
            if(word==word1){
                i1 = i;
            }
            if(word==word2)
            {
                i2 = i;
            }
            
            if(i1!=-1 && i2!=-1){
                ans = min(ans,abs(i1-i2));
            }
        }
        
        return ans;
    }
};

