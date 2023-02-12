// Time complexity: O(n) 
// Space complexity: O(1) 

// Approach : 2 pointer method

/*
there are repeated words and both the if blocks are entered 
when this happens, we want to preserve the old value of the word that was found and the new value 
We can do this by updating i1 to the old i2 value (-1 if this is the first time the word is seen or the previous i value where the word was found)
And update i2 to the current index 
This way, i2 now has the current value of i where the word is found. 

- i1 is -1 and i2 = i
- The next time the word is seen again, i1 would have gotten updated to the new i and we would have entered the second if condition too
- Here we can save the first word index thats stored in i2 to i1
- update i2 to the new i

*/

class Solution {
public:
    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {
        if(wordsDict.size() == 0)
            return 0;
        int i1 = -1, i2 = -1;
        int result = INT_MAX;
        for(int i =0; i < wordsDict.size(); i++) {
            if(wordsDict[i] == word1) {
                i1 = i;
            }
            if(wordsDict[i] == word2) { 
                // i1 is i and it enters this block only when both words are same
                if(i1 == i) {
                    // since both words are the same, save the new value in i2 and the old value of i2 in i1
                    i1 = i2;
                }
                i2 = i;
            }
            if(i1 != -1 && i2 != -1)
                result = min(result, abs(i1-i2));
        }
        return result;
    }
};