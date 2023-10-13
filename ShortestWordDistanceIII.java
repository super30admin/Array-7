// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ShortestWordDistanceIII {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

        int p1 = -1; int p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++){

            if(wordsDict[i].equals(word1)){
                p1 = i;
            }

            if(wordsDict[i].equals(word2)){
                if(p1 == i){
                    p1 = p2;
                }
                p2 = i;
            }

            if(p1 != -1 && p2!= -1){
                min = Math.min(min,Math.abs(p1-p2));
            }
        }
        return min;
    }
    
    /*
       public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

     int p1 = -1; int p2 = -1;
        int min = Integer.MAX_VALUE;
       for(int i=0; i<wordsDict.length; i++){
            if(word1.equals(word2))
            {
                if(wordsDict[i].equals(word1)){
                    if(p1 <= p2){
                        p1 = i;
                    }else{
                        p2 = i;
                    }
                    if(p1 != -1 && p2!= -1){
                    min = Math.min(min,Math.abs(p1-p2));
                    }
                }
            }else
            {
                if(wordsDict[i].equals(word1)){
                    p1 = i;
                }

                if(wordsDict[i].equals(word2)){
                        p2 = i;
                }

                if(p1 != -1 && p2!= -1){
                    min = Math.min(min,Math.abs(p1-p2));
                }
            }
       }
       return min;
    }
}
     */
}