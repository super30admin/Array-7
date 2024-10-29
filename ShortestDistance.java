// Problem 243. Shortest Word Distance
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                index1 = i;
            }
            if(wordsDict[i].equals(word2)){
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                minDist = Math.min(minDist, Math.abs(index1 - index2));
            }
        }
        return minDist;
    }
}