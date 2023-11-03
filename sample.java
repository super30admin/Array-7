//Problem 1: Minimum word distance
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// mark 2 pointers when we match word1 and word2 take absolute difference and store if it is new min
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
    
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) 
            p1 = i;

        if (words[i].equals(word2)) 
            p2 = i;
            
        if (p1 != -1 && p2 != -1)
            min = Math.min(min, Math.abs(p1 - p2));
    }
    return min;
    }
}


//Problem 2: Minimum word distance ii
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// do the same but take word1 index occurrences in a list and same with word2
// now as both lists are sorted, do 2 pointers on both and check where we find minimum.
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map= new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1= map.get(word1);
        List<Integer> l2= map.get(word2);

        int p1=0,p2=0,min=Integer.MAX_VALUE;

        while(p1<l1.size() && p2<l2.size()){
            min=Math.min(min, Math.abs(l1.get(p1)-l2.get(p2)));

            if(l1.get(p1)<l2.get(p2))
                p1++;
            else
                p2++;
        }
        return min;
    }
}

//Problem 3: Minimum word distance iii
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// word can be same or diff, for different words use earlier approach
// for same words, use 2 pointers and take absolute differences and check with global min.
class Solution {
    //O(n)
    public int shortestWordDistance(String[] wordsDict, String word1, String word2){
        int p1=-1,p2=-1,min=Integer.MAX_VALUE;
        if(word1.equals(word2)){
            for(int i=0;i<wordsDict.length;i++){
                if(wordsDict[i].equals(word1)){
                    if(p1<=p2){
                        p1=i;
                    }else{
                        p2=i;
                    }

                    if (p1 != -1 && p2 != -1)
                        min = Math.min(min, Math.abs(p1 - p2));
                }
            }
        }else{
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) 
                    p1 = i;

                if (wordsDict[i].equals(word2)) 
                    p2 = i;
            
                if (p1 != -1 && p2 != -1)
                    min = Math.min(min, Math.abs(p1 - p2));
                }
                
            }
        return min;
    }
}
