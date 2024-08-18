package Array-7;
// TC: O(N)
// SC: O(N)
public class Problem3 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1=-1;
        int p2=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            String word = wordsDict[i];
            if(word.equals(word1)){
                p1 = i;
            }

            if(word.equals(word2)){
                if(p1==i){
                    p1=p2;
                }
                p2=i;
            }

            if(p1!=-1 && p2!=-1){
                min = Math.min(min,Math.abs(p1-p2));
            }
        }

        return min;
    }
}
