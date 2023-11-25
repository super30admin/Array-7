public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++){
            //if words are not equal
            if(!word1.equals(word2)){

                if(wordsDict[i].equals(word1)){
                    i1 = i;
                }else if(wordsDict[i].equals(word2)){
                    i2 = i;
                }

                if(i1 != -1 && i2 != -1){
                     min = Math.min(min, Math.abs(i1-i2));
                }

            }else{
                if(wordsDict[i].equals(word1)){
                    if(i1 < i2){

                        i1 = i;

                    }else{
                        i2 = i;
                    }
                     if(i1 != -1 && i2 != -1){
                     min = Math.min(min, Math.abs(i1-i2));
                }
                }

            }
        }
        return min;
    }
}

//TC - O(nk)
//SC - O(1)