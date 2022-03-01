class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        //o(n) timea and const space
        int i1 = -1; int i2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                i1 = i;
            } else if(wordsDict[i].equals(word2)){
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                min = Math.min(min,Math.abs(i1-i2) );
            }
        }
        return min;

    }
}

class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        //o(n) timea and const space

        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String curr= wordsDict[i];
            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int i1 = 0; int i2 = 0;
        int min = Integer.MAX_VALUE;

        List<Integer> l1 = map.get(word1);
        List<Integer>l2 = map.get(word2);
        while(i1 < l1.size() && i2 < l2.size()  ){
            min = Math.min(min, Math.abs(l1.get(i1) - l2.get(i2)));
            if(l1.get(i1) < l2.get(i2)){
                i1++;
            } else  {
                i2++;
            }

        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */


class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        //o(n)time and cost space
        int i1 = -1; int i2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            if(!word1.equals(word2)){
                if(wordsDict[i].equals(word1)){
                    i1 = i;
                } else if(wordsDict[i].equals(word2)){
                    i2 = i;
                }
            } else {
                if(wordsDict[i].equals(word1)){
                    if(i1 <= i2){
                        i1 = i;
                    } else {
                        i2 = i;
                    }
                }

            }
            if(i1 != -1 && i2 != -1){

                min = Math.min(min,Math.abs(i1-i2));
            }

        }
        return min;

    }
}