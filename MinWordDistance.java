// TC: O(n^2)
// SC: O(1)

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(wordsDict[i].equals(word1)){
                for(int j=0; j<n; j++){
                    if(wordsDict[j].equals(word2)){
                        int diff = Math.abs(i - j);
                        min = Integer.min(min, diff);
                    }
                }
            }
        }
        return min;
    }
}
