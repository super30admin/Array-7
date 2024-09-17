class WordDistance {
public:
    unordered_map<string, vector<int>> um;
    
    WordDistance(vector<string>& words) {
        for (int i=0;i<words.size();i++) {
            um[words[i]].push_back(i);
        }
    }
    
    int shortest(string word1, string word2) {
        int ptr1=0,ptr2=0;
        int answer=INT_MAX;
        vector<int> word1Index=um[word1];
        vector<int> word2Index=um[word2];
        while (ptr1<word1Index.size() && ptr2<word2Index.size() ) {
            
            answer=min(answer,abs(word1Index[ptr1]-word2Index[ptr2]) );
            if (word1Index[ptr1]<word2Index[ptr2] ) {
                 ptr1++;
            } else {
                 ptr2++;
            }
        }
           
        return answer;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(words);
 * int param_1 = obj->shortest(word1,word2);
 */