public class Solution {
    // TC => O(n)
    // SC => O(1)
    public int ShortestDistance(string[] wordsDict, string word1, string word2) {
        if(wordsDict == null || wordsDict.Length == 0){
            return -1;
        }
        int i1 = -1, i2 = -1, min = Int32.MaxValue;

        for(int i = 0; i< wordsDict.Length; i++){
            if(wordsDict[i] == word1){
                i1 = i;
            }
            if(wordsDict[i] == word2){
                i2 = i;
            }
            if(i1 > -1 && i2 > -1){
                min = Math.Min(min, Math.Abs(i1 - i2));
            }
        }
        return min;
    }
}