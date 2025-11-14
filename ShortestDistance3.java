// This alorithm builds a map with string to indices list
// For each string pair, we iterate through these lists and find the minimum difference between those numbers
// If both strings are equal we make sure to move the p2 to the present index and p1 will be moved back to p2 which is last index
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
       int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
       for(int i=0;i<wordsDict.length;i++) {
        String temp = wordsDict[i];
        if(temp.equals(word1)) {
            p1=i;
        } if(temp.equals(word2)) {
            if(word1.equals(word2)) {
                p1=p2;
            }
            p2=i;
        }
        if(p1!=-1 && p2!=-1) min = Math.min(min, Math.abs(p1-p2));
       } 
       return min;
    }
}
