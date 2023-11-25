/*

The question is asking to return the shortest distance between two words in an array wordsDict. the distance can be from word 1 to 2 or 2 to 1 ,we just need to find the shortest distance

Intution:

We wil loop over the words, We can us two pointers ptr1 and pt2, ptr1 would always point to index of word1 and ptr2 would always point to  index of word2 . 
We will keep calculating minimum as we traverse. i.e when ptr1 or 2 finds another occurance of the corresponding word, we would take the distance and calculate from there

At the end we will calculate minimum

Time: O (n)
Space : O(1)

*/

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int ptr1 = -1, ptr2 = -1; // ptr1 would point to word1 occurance and ptr2 would point to word2 occurance
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                ptr1 = i;
            }
            else if(wordsDict[i].equals(word2)){
                ptr2 = i;
            }
            if(ptr1!=-1 && ptr2 != -1) //do calculation only if they are found
            min = Math.min(min, Math.abs(ptr2 - ptr1)); // keep calculating from whatever the values we keep on getting
        }
        return min;
    }
}