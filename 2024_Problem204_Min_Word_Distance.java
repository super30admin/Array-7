//243. Shortest Word Distance - https://leetcode.com/problems/shortest-word-distance/description/
/*
Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
 */
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            String word = wordsDict[i];
            if(word.equals(word1)){
                p1 = i;
            } else if(word.equals(word2)){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1){ //both words found, update distance
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }
}