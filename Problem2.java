// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String curr = wordsDict[i];
            if(!map.containsKey(curr)){
                map.put(curr,new ArrayList<>());
            }
            map.get(curr).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while(p1 < l1.size() && p2 < l2.size()){
            int ele1 = l1.get(p1);
            int ele2 = l2.get(p2);
            res = Math.min(res,Math.abs(ele1-ele2));
            if(ele1 < ele2)
                p1++;
            else
                p2++;
        }
        return res;
    }
}