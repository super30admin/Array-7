// Time : O(n. (2*l)) = O(N* L)
// Space : O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int word1AtIndex = -1;
        int word2AtIndex = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){ // n
            String word = wordsDict[i];
            if(word1.equals(word)){ // Avg length of l
                word1AtIndex = i;
            } 
            if(word2.equals(word)){ // Avg length of l
                word2AtIndex = i;
            }

            if(word1AtIndex!=-1 && word2AtIndex!=-1){
                min = Math.min(min , Math.abs(word1AtIndex - word2AtIndex));
            }
        }

        return min;
    }
}