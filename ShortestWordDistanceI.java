public class ShortestWordDistanceI {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int id1 = -1, id2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                id1 = i;
            }
            if(wordsDict[i].equals(word2)){
                id2 = i;
            }
            if(id1!=-1 && id2!=-1){
                min = Math.min(min, Math.abs(id1-id2));
            }
        }
        return min;
    }
}

// TC - O(nk)
// SC - O(1)
