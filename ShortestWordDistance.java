class Solution {

    //Time Complexity: 0(nk) where n is the length of wordsDict and k is the average length of words in it.
    //Space Complexity: 0(1)

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if(wordsDict == null || wordsDict.length == 0){
            return 0;
        }

        int i1 = -1;    //a pointer that captures the index of occurence of word 1 initially set to -1
        int i2 = -1;    //a pointer which capture the index of occurence of word 2
        int dist = Integer.MAX_VALUE;   //variable to return minimum distance between them

        for(int i = 0; i < wordsDict.length; i++){  //going over all the words in the array
            if(wordsDict[i].equals(word1)){ //if the current word is equal to i1
                i1 = i; //then I store it's index to i1
            }
            if(wordsDict[i].equals(word2)){ //do the same for i2
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){   //if both i1 and i2 are not -1, means I have found atleast 1 occurence of both the words. Hence I can compute min distance between them
                dist = Math.min(dist, Math.abs(i1-i2));
            }
        }

        return dist;    //distance will hold the minimum distance between the 2 words from its occurences. Hence I return that
    }
}