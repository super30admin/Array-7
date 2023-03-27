class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i = -1;
        int j = -1;
        int min=Integer.MAX_VALUE;
        for(int a =0; a<wordsDict.length;a++){
            if(wordsDict[a].equals(word1)) i=a;
            if(wordsDict[a].equals(word2)) j=a;
            if(i!=-1&&j!=-1) min = Math.min(min,Math.abs(i-j));
        }
    return min;}
}