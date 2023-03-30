/*

The question is asking to return the shortest distance between two words in an array wordsDict.

These words can be same as well

Intution:

We can us two pointers ptr1 and pt2, ptr1 would always point to index of word1 and ptr2 would always point to  index of word2 . 
We will keep calculating minimum as we traverse

For same words in the list
The two pointers approach would work, the ptr1 would always point to the previous index of ptr2 
to do that we can intrduce additional condtion, is that when the current pointer is pointo the same words, the make ptr1 point to ptr2 and then update the ptr2 to the index

At the end we will calculate minimum

Time: O (n)
Space : O(1)

*/

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

        int ptr1 = -1,ptr2 = -1;

        int min = Integer.MAX_VALUE;

        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                ptr1 = i;
            }
            else if(wordsDict[i].equals(word2)){
                ptr2 = i;
            }
            
            if(wordsDict[i].equals(word1) && wordsDict[i].equals(word2)){ // this would happen for the same word only
                    ptr1 = ptr2; // ptr1 is pointing to earlier value of ptr2 
                    ptr2 = i;
                }

            if(ptr1!=-1 && ptr2!=-1){
                min = Math.min(min, Math.abs(ptr2 - ptr1));
            }

        }

        return min;
        
    }
}