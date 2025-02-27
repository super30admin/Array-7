// Approach : Two pointer approach , since word1 and word2 can be equal we need add extra check during word2 and reset i1 pointer to previous i2
// Time: o(nl)
// Space: o(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int i1=-1;
        int i2=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                i1=i;
            }
            if(wordsDict[i].equals(word2)){
                if(i1 == i){
                    i1=i2;
                } i2=i;
            }
            if(i1!=-1 && i2!=-1){
                min = Math.min(min,Math.abs(i1-i2));
            }
        }
        return min;
    }
}