/*
245. Shortest Word Distance III
Ran on leetcode: Yes
TC: O(n) SC: O(1)
Track word1 and word2 using two pointers each tracking the most recent occurence if both the words are same in one pointer store the last most recent occurence of the word and in other pointer store the recent occurence, if we take distance between the word1 and word2 most recent occurence we will find the minmimum distance becasue they will occur nearby to each other
*/
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];

            if(word.equals(word1)){ // Stores the index to most recent locations of word1
                p1 = i;
            }

            if(word.equals(word2)){ // Stores the index to most recent locations of word2
                if(p1 == i){ // if both the words are same
                    p1 = p2; // store the last recent occurence of the word in p1
                }
                p2 = i;
            }

            if(p1 != -1 && p2 != -1){ // If both are found check the distance between most recent occurence of word1 and word2
                minDist = Math.min(minDist, Math.abs(p1 - p2));
            }
        }

        return minDist;
    }
}