// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. crete two pointers to point to first and second word.
//2. If two words are equal then i1 will be same as the index.
//3. change i1 value to i2
//4. update minimum distance at each find

class Solution {
public:
    int shortestWordDistance(vector<string>& words, string word1, string word2) {
        int size = words.size();
        int i1=-1, i2=-1;
        int min_dist = INT_MAX;
        for(int i=0; i<size; i++){
            if(words[i].compare(word1)==0){
                i1=i;
            }
            if(words[i].compare(word2)==0){
                if(i1==i)
                    i1=i2;
                i2=i;
            }
            if(i1 !=-1 && i2 != -1){
                min_dist = min(min_dist, abs(i1-i2));
            }
        }
        return min_dist;
    }
};
