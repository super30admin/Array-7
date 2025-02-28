//244. Shortest Word Distance3 - https://leetcode.com/problems/shortest-word-distance-iii/description/
/*
Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the shortest distance between the occurrence of these two words in the list.

Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
Output: 3
 */

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            String word = wordsDict[i];
            if(word1.equals(word2)){
                if(word.equals(word1)){
                    if(p1 < p2){
                        p1 = i;
                    } else {
                        p2 = i;
                    }
                }
            } else {
                if(word.equals(word1)){
                    p1 = i;
                } else if(word.equals(word2)){
                    p2 = i;
                }
            }

            if(p1 != -1 && p2 != -1){ //both words found, update distance
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }
}
