//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code run successfully on leetcode : Yes
//Have you faced any problem while running this code : No
class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];
            if(word.equals(word1)) {
                p1 = i;
            } else if(word.equals(word2)) {
                p2 = i;
            } if(p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }
}