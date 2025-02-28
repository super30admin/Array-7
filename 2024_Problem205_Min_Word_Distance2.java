//244. Shortest Word Distance2 - https://leetcode.com/problems/shortest-word-distance-ii/description/
/*
Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.

Example 1:

Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1
 */
//Time Complexity: O(k1+k2)
//Space Complexity: O(n) ~ HashMap space

class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }
    //get list belonging to the word
    public int shortest(String word1, String word2) {
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        int min = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;

        while(p1 < word1List.size() && p2 < word2List.size()){
            if(word1List.get(p1) < word2List.get(p2)){
                min = Math.min(min, word2List.get(p2) - word1List.get(p1));
                p1++;
            } else {
                min = Math.min(min, word1List.get(p1) - word2List.get(p2));
                p2++;
            }
        }
        return min;
    }
}
