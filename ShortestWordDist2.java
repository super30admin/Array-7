// Time Complexity : O(occurances of word1 + occurances of word2 + words length)
// Space Complexity : O(words and their occurances) HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Get all the occurances of all the words in a hashmap. Get the occurances of all
the words. Now see the indices of word 1 and word 2. The indices are in sorted order. Either you can do Binary search on one list for each of element
in other list or use two pointers to get the shortest distance.
*/
class WordDistance {
    Map<String, List<Integer>> store;
    public WordDistance(String[] words) {
        store = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!store.containsKey(words[i])){                                                               // Get all the words and their occurances
                List<Integer> li = new ArrayList<>();
                li.add(i);
                store.put(words[i], li);                                                                    // Add all the occurances of the word
            } else {
                store.get(words[i]).add(i);                 
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if(store.containsKey(word1) && store.containsKey(word2)){
            List<Integer> list1 = store.get(word1);                                                                     // Get occurances of word 1
            List<Integer> list2 = store.get(word2);                                                         // Get occurances of word 2
            int i = 0, j = 0;
            while(i < list1.size() && j < list2.size()){
                if(Math.abs(list1.get(i) - list2.get(j)) < min){                                                    // Keep the minimum distance
                    min = Math.abs(list1.get(i) - list2.get(j));
                } else 
                if(list1.get(i) > list2.get(j)){                                                            // If the number is greater, move the smaller number's pointer as we need min dist
                    j++;
                } else {
                    i++;
                }
            }
        } else {
            return 0;                                                                                   // If word is not present in the map
        }
        return min;
    }
}