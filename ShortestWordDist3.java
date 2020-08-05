// Time Complexity : O(words length)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: If the word 1 is present in the words array,  take the index to the i. If the word
is same in word 2, check if word has already occured at i, then keep i with word at j, and keep the min distance. Update j everytime you see a
new word and keep i with previous time occured index.
*/
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0) return 0;
        int i =-1 , j =-1, k= 0, min = Integer.MAX_VALUE;
        while(k < words.length){
            if(words[k].equals(word1)){                                                                                 // Get the word 1 index
                i = k;
            }
            if(words[k].equals(word2)){
                 if(i == k)                                                                                 // If word has already occured
                        i = j;                                                                          // Update the i pointer with j occurance
                 j = k;                                                                                 // Keep the latest occurance of word at j  
            }   
            if(i != -1 && j != -1)
                min = Math.min(min,  Math.abs(j - i));                                                          // Keep the min distance
            k++;
        }
        return min;
    }
}