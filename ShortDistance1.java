//TC = O(n)
//SC = O(1)

//Here we are using 1 pass solution. we will keep two pointers to track two words.

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                i1 = i;
            }if(wordsDict[i].equals(word2)){
                i2 = i;
            }
            if(i1 !=-1 && i2 != -1 ){
                res = Math.min(res, Math.abs(i1-i2));   
            }    
        }
        return res;
    }
}