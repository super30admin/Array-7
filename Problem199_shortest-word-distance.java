// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int idxw1 = -1;
        int idxw2 = -1;
        for(int i = 0; i < wordsDict.length; i++) {
            if(word1.equals(wordsDict[i]))
                idxw1 = i;
            else if(word2.equals(wordsDict[i]))
                idxw2 = i;
            if(idxw1 != -1 && idxw2 != -1)
                min = Math.min(min, Math.abs(idxw1 - idxw2));
        }
        return min;
    }
}