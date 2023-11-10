//TC = O(nk)
//SC = O(1)
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n ; i++){
            if(!word1.equals(word2)){
                if(wordsDict[i].equals(word1)){
                    i1 = i;
                }if(wordsDict[i].equals(word2)){
                    i2 = i;
                }
                if(i1 !=-1 && i2 != -1){
                    min = Math.min(min, Math.abs(i1-i2));
                }
            }
            else{
                if(wordsDict[i].equals(word2)){
                    if(i1<=i2){
                        i1 = i;
                    }else{
                        i2 = i;
                    }
                if(i1 != -1 && i2 != -1){
                    min = Math.min(min, Math.abs(i1-i2));
                }
                }
            }
        }
return min;
    }
}