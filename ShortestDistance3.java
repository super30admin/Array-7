class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        int n = wordsDict.length;
        for(int i=0;i<n;i++){
            if(word1.equals(word2)){
                if(wordsDict[i].equals(word1)){
                    if(p1<p2){
                        p1 = i;
                    }else{
                        p2 = i;
                    }
                }
            }else{
                if(wordsDict[i].equals(word1)){
                    p1 = i;
                }
                if(wordsDict[i].equals(word2)){
                    p2 = i;
                }
                
            }
            if((p1!=-1 && p2!=-1)){
                    min = Math.min(min,Math.abs(p1-p2));
                }
        }
        return min;
    }
}



//TC------>O(n)
//SC------>O(1)