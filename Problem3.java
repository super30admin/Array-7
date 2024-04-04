public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
     //TC: O(n)
     //Sc: O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here'
        if(words == null) return 0;
        int i1 = -1, i2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <words.length; i++){
            if(words[i].equals(word1)) i1 = i;
            if(words[i].equals(word2)){
                if(i1 == i){
                    i1 = i2;
                }
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                min = Math.min(min,Math.abs(i2-i1));
            }
        }
        return min;
     }
}
