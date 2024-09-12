//Method-1
class Solution {

    //Time Complexity : 0(nk) where n is the length of the wordsDict array an k is the avg length of the words in it
    //Space Complexity: 0(1)

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if(wordsDict == null || wordsDict.length == 0){
            return 0;
        }

        int i1 = -1;
        int i2 = -1;
        int dist = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++){
            if(!word1.equals(word2)){   //For this case, there will be 2 conditions. 1- If word 1 and word 2 is not same
                if(word1.equals(wordsDict[i])){ //Then I store the occurence of word 1's index in my i1 pointer
                    i1 = i;
                }
                if(word2.equals(wordsDict[i])){ //and word 2's occurence in i2 pointer
                    i2 = i;
                }
            }
            else{   //of if both word1 and word2 are same
                if(word1.equals(wordsDict[i])){ //then I just need to check for any one of the words
                    if(i1 <= i2){   //I store the occurence of the word one by 1 one i1 and then in i2.
                        i1 = i;
                    }
                    else{
                        i2 = i;
                    }
                }
            }
            if(i1 != -1 && i2 != -1){   //I compute the min dist.
                dist = Math.min(dist, Math.abs(i1 - i2));
            }

        }

        return dist;    //and return the min distance
    }
}

//Alternate method which I dont have to check if word1 and word 2 are same or not

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if(wordsDict == null || wordsDict.length == 0){
            return 0;
        }

        int i1 = -1;
        int i2 = -1;
        int dist = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++){
            if(word1.equals(wordsDict[i])){ //if word 1 is equal to current word, then I store it's occurence in i1
                i1 = i;
            }
            if(word2.equals(wordsDict[i])){ //if word 2 is equal to current word, then
                if(i1 <= i2){   //I check If i1 is less than or equal to i2 or not. If yes,
                    i1= i;  //then I just update the current position of the occurence of the word to i1
                }
                else{   //if i2 is smaller, then I store the occurence in i2
                    i2 = i;
                }
            }
            if(i1 != -1 && i2 != -1){
                dist = Math.min(dist, Math.abs(i1 - i2));
            }

        }

        return dist;
    }
}