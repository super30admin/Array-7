//Time: O(n)
//Space: O(1)
//Program ran on leetcode successfully

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int l=-1, r= -1;
        int s = Integer.MAX_VALUE;
        for(int i=0; i< words.length; i++){
            if(word1.equals(words[i])){
                l = i;
                if( l >=0 && r >=0){
                    //if word1 == word2, then r is the last index, and l is current index;
                    s = l ==r ? s : Math.min(s, Math.abs(l-r)); 
                }
            }
            if(word2.equals(words[i])){
                r = i;
                if(l >=0 && r >=0){
                    s = l ==r ? s : Math.min(s, Math.abs(l-r));
                }
            }
        }

        return s;
    }
}