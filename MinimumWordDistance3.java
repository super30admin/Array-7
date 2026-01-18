// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We use two pointers approach to solve this problem. We capture the occurence of word1 in first and word2 in second and maintain
// the minimum distance in result while traversing the wordDict array. When same word comes, we update the first pointer to point to the second
// which was already pointing to it's previous occurence so that we differentiate them and calculate the distance.

class Solution {
    int shortestDistance(String[] wordsDict, String word1, String word2) {
        int first = -1;
        int second = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                first = i; //first occurence index
            }
            if (wordsDict[i].equals(word2)) {
                if(first == i){ //when two words are equal
                    first = second; //point the first to second
                }
                second = i;
            }
            if (first != -1 && second != -1) {
                res = Math.min(res, Math.abs(first - second)); //minimum distance
            }
        }

        return res;
    }
}
