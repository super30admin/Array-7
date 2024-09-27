// TC - O(n)

// SC - O(1)

// LC - 245

// class Solution {
//     public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
     
//         Map<String, List<Integer>> map = new HashMap<>();
        
//         for(int i=0; i<wordsDict.length; i++){
//             map.putIfAbsent(wordsDict[i], new ArrayList<>());
//             map.get(wordsDict[i]).add(i);
//         }
//         int min = Integer.MAX_VALUE;
//         if(word1.equals(word2)){
//             List<Integer> list = map.get(word1);
//             for(int i=0; i<list.size()-1; i++){
//                 min = (Math.min(min, list.get(i+1) - list.get(i)));
//             }
//             return min;
//         }
//         List<Integer> w1 = map.get(word1);
//         List<Integer> w2 = map.get(word2);
        
//         for(int i=0; i<w1.size(); i++){
//             for(int j=0; j<w2.size(); j++){
//                 min = Math.min(min, Math.abs(w1.get(i) - w2.get(j)));
//             }
//         }
//         return min;
//     }
// }

class Solution{
    public int shortestWordDistance(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1))
                i1 = i;
            if (words[i].equals(word2)) {
                if (word1.equals(word2))
                    i1 = i2;
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }    
}
