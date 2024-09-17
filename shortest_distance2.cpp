// Time Complexity : O(m+k) (Total number of matches found for word1: m, word2: n)
// Space Complexity : O(n)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Create a hashmap to store all the words with occurence index
//2. Get the arrays from the hashmap and compare each index to find the min length using two pointers
//3. Return the min distance

class WordDistance {
public:
    unordered_map<string, vector<int>> word_map; 
    WordDistance(vector<string>& words) {
        int i=0;
        for(auto word:words){ //O(n) : but not counted because of the design
            word_map[word].push_back(i);
            i++;
        }
    }
    
    int shortest(string word1, string word2) {
        vector<int> vec1 = word_map[word1];
        vector<int> vec2 = word_map[word2];
        int v1=0, v2=0;
        int i1, i2;
        int min_dist= INT_MAX;
        while(v1<vec1.size() && v2<vec2.size()){
            i1=vec1[v1]; i2=vec2[v2];
            min_dist = min(min_dist, abs(i1-i2));
            if(i1>i2)
                v2++;
            else
                v1++;
        }
         return min_dist;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(words);
 * int param_1 = obj->shortest(word1,word2);
 */
