//Time - O(n)
//Space - O(1)
class Solution {
    public:
    
    int shortestDistance(vector<string> words, string word1, string word2){
        int j = -1, k = -1;
        int ans = words.size()+1;
        for(int i = 0;i<words.size();i++){
            string word = words[i];
            
            if(word == word1){
                j = i;
            }
            if(word == word2){
                if(j == i){
                    j = k;
                }
                k = i;
            }
            
            if(j!=-1 && k!=-1){
                ans = min(ans, abs(j-k));
            }
        }
        
        return ans;
    }
}