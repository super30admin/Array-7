// TC - O(n)

// SC - O(1)

// LC - 243

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int w1 = -1, w2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                w1 = i;
            }else if(wordsDict[i].equals(word2)){
                w2 = i;
            }
            if(w1 != -1 && w2 != -1){
                min = Math.min(min, Math.abs(w1 - w2));
            }
        }
        return min;
    }
}

// class Solution {
//     public int shortestDistance(String[] wordsDict, String word1, String word2) {
//         if(wordsDict == null || wordsDict.length == 0){
//             return -1;
//         }
//         List<Integer> w1 = new ArrayList<>();
//         List<Integer> w2 = new ArrayList<>();
        
//         for(int i=0; i<wordsDict.length; i++){
//             if(word1.equals(wordsDict[i])){
//                 w1.add(i);
//             }else if(word2.equals(wordsDict[i])){
//                 w2.add(i);
//             }
//         }
//         int min = Integer.MAX_VALUE;
//         if(w1.size() == 0 || w2.size() == 0){
//             return -1;
//         }
//         for(int i=0; i<w1.size(); i++){
//             for(int j=0; j<w2.size(); j++){
//                 min = Math.min(min, Math.abs(w1.get(i) - w2.get(j)));
//             }
//         }
//         return min;
//     }
// }