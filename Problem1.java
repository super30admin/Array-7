package Array-7;
// TC: O(n)
// SC: O(1)
public class Problem1 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1=-1,p2=-1, min = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            
            if(word1.equals(wordsDict[i])){
                p1 = i;
            }

            if(word2.equals(wordsDict[i])){
                p2 = i;
            }
            if(p1!=-1 && p2!=-1){
                 min = Math.min(min, Math.abs(p1-p2));
            }
           
        }

        return min;
    }
}
