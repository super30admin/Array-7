// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : no
// Approach : Use two pointers to indicate the recent occurences of word1 or word2. Initially set poitners to -1, iterate
/// through array and if word matches word1 or word2, update corresponding pointer. Find min distance between pointers
/// To handle case where both pointers are same, we can check if word1 is at current index and so is word2, in that case move
/// p1 pointer to current position of p2 and p2 to i 
/*
Shorted distance between word 1 - Given array od words and two words. Find the minimum distance between them. Given that thw two words may be same
*/ 
public class MinDist3{
    public static void main(String args[]){
        String words[] = {"leetcode", "practice", "practice", "perfect", "practice", "leetcode", "makes", "practice", "makes", "perfect", "leetcode", "perfect"};
        String word1 = "practice";
        String word2 = "practice";
        int minDist = solve(words, word1, word2);
        System.out.println("Minimum Distance = "+minDist);
    }
    public static int solve(String words[], String word1, String word2){
        if(words.length==0 || word1.length()==0 || word2.length()==0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        int p1 = -1, p2 = -1;
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            if(curr.equals(word1)){
                p1 = i;
            }
            if(curr.equals(word2)){
                if(p1==i){
                    p1 = p2;
                }
                p2 = i;
            }
            if(p1!=-1 && p2!=-1){
                res = Math.min(res, Math.abs(p1-p2));
            }
        }
        return res;
    }
}