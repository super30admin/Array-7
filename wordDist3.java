// tc : O(n)
// sc : O(n)

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        // map : words <- locations 
        for(int i  = 0 ; i<wordsDict.length ; i++)
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        // find min
        int res = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for(int i = 0, j = 0 ; i<list1.size() && j < list2.size() ; ){
            int ind1 = list1.get(i), ind2 = list2.get(j);
            if(ind1 < ind2){
                res = Math.min(res, Math.max(1,ind2 - ind1));
                i++;
            }
            else if (ind1 == ind2)
                j++;
            else 
             {
                res = Math.min(res, Math.max(1,ind1 - ind2));
                j++;
            }
        }
        return res;
    }
}
