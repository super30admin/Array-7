// tc : O(n)
// sc : O(1)

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int a = -1;
        int b = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < wordsDict.length ; i++){
            String word = wordsDict[i];
            if(word.equals(word1))
                a = i;
            else if (word.equals(word2))
                b = i;
            if(a!=-1 && b!=-1)
                res = Math.min(Math.abs(b-a), res);
        }
        return res;               
    }
}
