class Solution {
public:
    int shortestWordDistance(vector<string>& words, string word1, string word2) {
        int idx1=-1;
        int idx2=-1;
        int answer=INT_MAX;
        for (int i=0;i<words.size();i++) {
            if (word1 == words[i]) {
                //cout<<word1<<" "<<words[i]<<endl;
                idx1=i;
            }
            if (word2 == words[i]) {
                //cout<<word2<<" "<<words[i]<<endl;
                if (word1 == word2) {
                    idx1=idx2;
                }
                idx2=i;
            } 
            if (idx1!=-1 && idx2!=-1) {
                answer=min(answer,abs(idx1-idx2));
            }
        }
        return answer;
    }
};