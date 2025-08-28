// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : no
// Approach : Preprocess words into map of word to list of index where word occurs in the words array. For each query.
/// get lsit of word1 and word2. Use two pointers, each at beginning of both the lists. Find difference, move the ptr 
/// pointing to the value that is smaller. Return the min dist we found
/*
Shorted distance between word 1 - Given array od words and two words. Find the minimum distance between them. Given that the two words can keep changing dynamically
*/ 
public class MinDist2{
    static HashMap<String, List<Integer>> map;
    public static void main(String args[]){
        String words[] = {"leetcode", "practice", "practice", "perfect", "practice", "leetcode", "makes", "practice", "makes", "perfect", "leetcode", "perfect"};
        map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
        String word1 = "practice";
        String word2 = "makes";
        int minDist = solve(words, word1, word2);
        System.out.println("Minimum Distance = "+minDist);
        word1 = "leetcode";
        word2 = "perfect";
        minDist = solve(words, word1, word2);
        System.out.println("Minimum Distance = "+minDist);
    }
    public static int solve(String words[], String word1, String word2){
        if(words.length==0 || word1.length()==0 || word2.length()==0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        while(p1<li1.size() && p2<li2.size()){
            int val1 = li1.get(p1);
            int val2 = li2.get(p2);
            res = Math.min(res, Math.abs(val1-val2));
            if(val1<=val2){
                p1++;
            }
            else{
                p2++;
            }
        }
        return res;
    }
}