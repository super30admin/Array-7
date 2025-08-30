// TC: O(n)
// SC: O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int min = Integer.MAX_VALUE;

        int i1 = -1;
        int i2 = -1;

        for(int i=0; i < n; i++){
            String curr = wordsDict[i];

            if(curr.equals(word1)){
                i1 = i;

            }
            if(curr.equals(word2)){
                if( i1 == i){ // detect same
                    i1 = i2; // last occurance matters so reset first
                }
                i2 = i;
            }

            if(i1 != -1 && i2 != -1){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }

        return min;
    }
}
