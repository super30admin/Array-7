
//TC: O(n)
//SC: O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if(wordsDict==null || wordsDict.length==0){
            return -1;
        }
        int i1=-1;
        int j=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            String curr=wordsDict[i];
            if(curr.equals(word1)){
                i1=i;
            }
            if(curr.equals(word2)){
                j=i;
            }
            if(i1!=-1 && j!=-1){
                min=Math.min(min,Math.abs(i1-j));
            }
        }
        return min;
    }
}