class ShortestWordDistance {
    
    //time: O(n)
    //space:O(1)
    //did it run successfully on leetcode: yes
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        //index to keep track of word1 and word2
        int i1 = -1, i2=-1;
        
        //variable to store min distance
        int min = Integer.MAX_VALUE;
        
        //looping through input words
        for(int i=0; i<wordsDict.length; i++){
            
               //if word1 found
                if(wordsDict[i].equals(word1)){

                    //update index for word1
                    i1 = i;
                }

                //if word2 found
                if(wordsDict[i].equals(word2)){
                    
                    //if word1 and word2 is same
                    if(word1.equals(word2)){
                        i1=i2;
                    }
                    
                    //update index for word2
                    i2 = i;
                }

                //if both word1 and word2 has been found
                if(i1!=-1 && i2!=-1){

                    //find min distance between word1 and word2
                    min = Math.min(min, Math.abs(i1-i2));
                } 
   
        }
        return min;
    }
}