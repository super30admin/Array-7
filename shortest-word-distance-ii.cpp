//Time - O(n)
//Space - O(n)
class WordDistance {
  public:
    unordered_map<string, vector<int>> umap;
    WordDistance(vector<int> words){
        for(int i = 0;i<words.size();i++){
            string word = words[i];
            umap[word].push_back(i);
        }
    }
    
    int shortestDistance(string word1, string word2){
        vector<int> indices1 = umap[word1];
        vector<int> indices2 = umap[word2];
        int p1 = 0, p2 = 0;
        int ans = INT_MAX;
        while(p1<indices1.size() && p2<indices2.size()){
            int idx1 = indices1[p1];
            int idx2 = indices2[p2];
            ans = min(ans, abs(idx1-idx2));
            if(ans == 1) return ans;
            if(idx1<idx2){
                p1++;
            }else{
                p2++;
            }
        }
        
        return ans;
    }
};