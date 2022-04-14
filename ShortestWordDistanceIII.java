package array7;

public class ShortestWordDistanceIII {
	//Time Complexity : O(n), where n is length of wordDict array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // null
        if(wordsDict == null || wordsDict.length == 0)
            return 0;
        
        int n1 = -1;
        int n2 = -1;
        int min = Integer.MAX_VALUE;
        int same = -1;
        
        for(int i=0; i<wordsDict.length; i++) {
            String word = wordsDict[i];
            if(word1.equals(word2)) {
                if(word.equals(word1)) {
                    if(same != -1)
                        min = Math.min(min, i - same);
                    same = i;
                }
            } 
            else {
                if(word.equals(word1)) {
                    n1 = i;
                } else if(word.equals(word2)) {
                    n2 = i;
                }
                if(n1 != -1 && n2 != -1)
                    min = Math.min(min, Math.abs(n1 - n2));
            }
        }
        
        return min;
    }
}
