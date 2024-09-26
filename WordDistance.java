// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : Te space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class WordDistance {

    Map<String,List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        //store the indices of each word in a map
        for(int i=0;i<wordsDict.length;i++){

            String str = wordsDict[i];
            List<Integer> li = map.getOrDefault(str,new ArrayList<>());
            li.add(i);
            map.put(str,li);

        }
    }

    public int shortest(String word1, String word2) {

        int res = Integer.MAX_VALUE;

        int w1 = 0;
        int w2 = 0;

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        //iterate through the indices of the words and find the minimum distance
        while(w1 < l1.size() && w2 < l2.size()){
            res = Math.min(res,Math.abs(l1.get(w1)-l2.get(w2)));

            if(l1.get(w1) < l2.get(w2)){
                w1++;
            }
            else{
                w2++;
            }
        }

        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */