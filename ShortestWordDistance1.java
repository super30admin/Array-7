// This solution uses a two pointer approach to maintain latest encountered index for word1 or word2 in the given array
// Whenever a word is encountered we update its corresponding index
// If at all both indices are encountered we update the minimum value
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++) {
            String word = wordsDict[i];
            if(word.equals(word1)) {
                p1 = i;
            } else if(word.equals(word2)) {
                p2 = i;
            }
            if(p1!=-1 && p2!=-1) {
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }
}
