// Shortest Word Distance
// Time Complexity: O(n) where n = length of words array
// Space Complexity: O(1) no extra space

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }
        // initializing positions and min distance
        int pos1 = -1;
        int pos2 = -1;
        int min = Integer.MAX_VALUE;
        // looping over words
        for (int i=0; i<words.length; i++) {
            // if found word1, change pos1
            if (words[i].equals(word1)) {
                pos1 = i;
            } else if (words[i].equals(word2)) { // if found word2, change pos2
                pos2 = i;
            }
            
            if (pos1 >= 0 && pos2 >= 0) { // calculate distance only if both are valid positions
                min = Math.min(min, Math.abs(pos1 - pos2));
            }
        }
        // return min distance
        return min;
    }
}

// Shortest Word Distance II
// Time Complexity: O(n) -> to create HashMap and O(n + m) to return min distance
// Space Complexity: O(n) extra space for hashmap where n = distinct words present in array

class WordDistance {
    
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        // create hashmap with value as list of positions
        map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        // iterate to find min distance
        while (i < list1.size() && j < list2.size()) {
            int pos1 = list1.get(i);
            int pos2 = list2.get(j);
            // calculate min distance
            min = Math.min(min, Math.abs(pos1 - pos2));
            // increment index for smaller one
            if (pos1 < pos2) {
                i += 1;
            } else {
                j += 1;
            }
        }
        // return min distance
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

// Shortest Word Distance III
// Time Complexity: 
// Space Complexity: 

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int min = Integer.MAX_VALUE;
        // for same words
        if (word1.equals(word2)) {
            for (int i=0; i<words.length; i++) {
                if (words[i].equals(word1)) {
                    pos1 = pos2; // assign pos2 to pos1
                    pos2 = i; // change pos2 to current position
                }
                // calculate min distance if both are valid posiitons
                if (pos1 >= 0 && pos2 >= 0) {
                    min = Math.min(min, Math.abs(pos1 - pos2));
                }
            }
        } else { // for different words
            for (int i=0; i<words.length; i++) {
                // get latest position for word1
                if (words[i].equals(word1)) {
                    pos1 = i;
                } else if (words[i].equals(word2)) { // get latest position for word2
                    pos2 = i;
                }
                // calculate distance if both positions are valid
                if (pos1 >= 0 && pos2 >= 0) {
                    min = Math.min(min, Math.abs(pos1 - pos2));
                }
            }
        }
        // return min distance
        return min;
    }
}
