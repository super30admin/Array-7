//Time:O(max(word1,word2)) 
//Space:O(n) HashMap to store word and index pair(Not accounted for shortest Function)
class WordDistance {
    unordered_map<string,vector<int>> hMap;
public:
    WordDistance(vector<string>& wordsDict) {
        for(int i = 0; i < wordsDict.size();i++){
            string word = wordsDict[i];
            hMap[word].push_back(i);
        }
    }
    
    int shortest(string word1, string word2) {
        vector<int> indexArr1 = hMap[word1],indexArr2 = hMap[word2];
        int ptr1 = 0, ptr2 = 0;
        int minDiff = INT_MAX;
        while(ptr1 < indexArr1.size() and ptr2 < indexArr2.size()){
            int index1 = indexArr1[ptr1];
            int index2 = indexArr2[ptr2];
            if(index1 < index2){
                minDiff = min(minDiff , abs(index2-index1));
                ptr1++;
            }
            else{
                minDiff = min(minDiff , abs(index2-index1));
                ptr2++;
            }
        }
        return minDiff;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(wordsDict);
 * int param_1 = obj->shortest(word1,word2);
 */