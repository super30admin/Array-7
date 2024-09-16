// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Take two pointers, to point the index, the get both the index and take a difference bwtween the both, and store the min
// Your code here along with comments explaining your approach
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int a = -1;
        int b = -1;
        int min = Integer.MAX_VALUE;
        for(int i  = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                a = i;
            }
            else if(wordsDict[i].equals(word2)){
                b = i;
            }
            if( a != -1 && b != -1){
                min = Math.min(min, Math.abs(a-b));
            }
        }
        return min;
    }
}