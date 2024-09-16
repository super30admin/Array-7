// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Take two pointers, to point the index, if the words are same, then just set the start with the old index and old index to the current index: (a = b; b = i)
// Your code here along with comments explaining your approach
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int s1 = n+1;
        int s2 = n+1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(wordsDict[i].equals(word1) && !word1.equals(word2)){
                s1 = i;
            }
            if(wordsDict[i].equals(word2) && !word1.equals(word2)){
                s2 = i;
            }
            if(word1.equals(word2) && wordsDict[i].equals(word2)){
                s1 = s2;
                s2 = i;
            }
            if( s1 < n && s2 < n){
                min = Math.min(min, Math.abs(s1-s2));
            }
        }
        return min;
    }
}