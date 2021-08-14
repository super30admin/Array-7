//Time:O((n) where n is the size of the wordsDict
//Space:O(1) No Extra Space
class Solution {
public:
    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {
        int p1 = -1;
        int p2 = -1;
        int shortDist = INT_MAX;
        for(int i = 0; i < wordsDict.size();i++){
            string word = wordsDict[i];
            if(word == word1){
                p1 = i;
            }
            if(word == word2){
                if(word1 == word2) p1=p2;
                p2 = i;
            }
            if(p1 != -1 and p2 != -1){
               shortDist = min(shortDist, abs(p2-p1));
            }
        }
        return shortDist;
    }
};