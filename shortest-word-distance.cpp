//Time - O(n)
//Space - O(1)
class Solution {
    public:
    int shortestWordDistance(vector<int> words, string word1, string word2){
        int k = -1, j = -1;
        int ans = words.size()+1;
        for(int i = 0;i<words.size();i++){
            string word = words[i];
            
            if(word == word1){
                k = i;
            }else if(word == word2){
                j = i;
            }
            
            if(k!=-1 && j!=-1){
                ans = min(ans, abs(k-j));
            }
        }
        if(k!=-1 && j!=-1) return ans;
        return -1;
    }
};