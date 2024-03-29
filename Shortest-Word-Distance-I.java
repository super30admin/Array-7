// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Iterate through the array, find word1 and word2 and place a pointer at both
// the words, find the min distance between them.

// 243. Shortest Word Distance

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int count = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                i1 = i;
            }
            if(wordsDict[i].equals(word2)){
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                count = Math.min(count,Math.abs(i1-i2));
            }
        }
        return count;
    }
}