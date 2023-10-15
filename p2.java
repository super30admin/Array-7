// Time Complexity :O(n) for shortest
// Space Complexity :O(1) for shortest
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class WordDistance {
HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        //store indexes of word in hashmap
        for(int i=0; i<wordsDict.length; i++){
            String word = wordsDict[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            List<Integer> list = map.get(word);
            list.add(i);
        }
    }
    //go through the list of indexes using two pointer approach to get the min distance
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;
        while(l1 != list1.size() && l2 != list2.size()){
            int p1 = list1.get(l1);
            int p2 = list2.get(l2);
            min = Math.min(min, Math.abs(p1-p2));
            if(p1 > p2){
                l2++;
            }
            else{
                l1++;
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