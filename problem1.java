//Time Complexity -> O(nl)
//Space Complexity -> O(1)
class Solution{
    public int shortestDistance(string[] wordsDict, string word1, string word2){
        int i1 = -1;
        int i2 = -1;
        if(wordsDict == null)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            String curr = wordsDict[i];
            if(word1.equals(curr)){
                i1 = i;
            }
            if(word2.equals(curr)){
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                min = Math.min(min, Math.abs(i2 - i1));
            }
        }
        return min;
        }
}
