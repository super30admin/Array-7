public class Solution {
    
    // TC => O(n)
    // SC => O(1)
    public int ShortestWordDistance(string[] wordsDict, string word1, string word2) {
        if(wordsDict == null || wordsDict.Length == 0){
            return -1;
        }
        int i1 = -1, i2 = -1, min = Int32.MaxValue;
        for(int i = 0; i< wordsDict.Length; i++){
            string word = wordsDict[i];
            if(word.Equals(word1)){
                    i1 = i;
            }
            if(word.Equals(word2)){
                if(i1 == i){
                    i1 = i2;
                }
                i2 = i;
            }
            if(i1 > -1 && i2 > -1){
                min = Math.Min(min, Math.Abs(i1 -i2));
            }
        }

        return min;
    }
    // TC => O(n)
    // SC => O(1)
    public int ShortestWordDistance1(string[] wordsDict, string word1, string word2) {
        if(wordsDict == null || wordsDict.Length == 0){
            return -1;
        }
        int i1 = -1, i2 = -1, min = Int32.MaxValue;
        for(int i = 0; i< wordsDict.Length; i++){
            string word = wordsDict[i];
            if(!word1.Equals(word2)){
                if(word.Equals(word1)){
                    i1 = i;
                }
                if(word.Equals(word2)){
                    i2 = i;
                }
            }
            else{
                if(word.Equals(word1)){
                    i1 = i2;
                    i2 = i;
                }
            }
            if(i1 > -1 && i2 > -1){
                    min = Math.Min(min, Math.Abs(i1 -i2));
            }
        }

        return min;
    }
}