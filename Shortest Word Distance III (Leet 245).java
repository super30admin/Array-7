/*
Time: O(n)
Space: O(1)
Executed Successfully on Leet: Yes
*/

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for(int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];
            if (word.equals(word1)){
                p1 = i;
            }
            if (word.equals(word2)){
                if (p1 == i){
                    p1 = p2;
                }
                p2 = i;
            }
            
            if (p1 != -1 && p2 != -1){
                res = Math.min(res, Math.abs(p1-p2));
            }
            
        }
        return res;
    }
}

/*
Time: O(n)
Space: O(1)
Executed Successfully on Leet: Yes
This requires if and else for loops
*/

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int i = 0;
        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        if (!word1.equals(word2)){
            while(i < wordsDict.length){
                String w1 = wordsDict[i];
                if (w1.equals(word1)){
                    p1 = i;
                }
                if (w1.equals(word2)){
                    p2 = i;
                }
                if(p1 != -1 && p2 != -1){
                    res = Math.min(res, Math.abs(p1-p2));
                }
                i++;
            }
        }else{
            while(i < wordsDict.length){
                String w1 = wordsDict[i];
                if (w1.equals(word1)){
                    if(p1 == -1 && p2 == -1){
                    p1 = i;
                    }else if(p1 < p2){
                        p1 = i;
                    }else{
                        p2 = i;
                    }
                }
                if(p1 != -1 && p2 != -1){
                    res = Math.min(res, Math.abs(p1-p2));
                }
                i++;
            }
        }
            
        return res;
    }
}
