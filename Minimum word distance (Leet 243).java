/*
Time: O(n)
Space: O(1)
Executed Successfully on Leet: Yes
*/

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i = 0;
        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        while(i < wordsDict.length){
            String w1 = wordsDict[i];
            if (w1.equals(word1)){
                p1 = i;
            }
            if (w1.equals(word2)){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1){
                res = Math.min(res, Math.abs(p1-p2));
            }
            i++;
        }
        System.out.println(p1);
        System.out.println(p2);
            
        return res;
    }
}

//////////////////////////////////////////////////////////////////////

/*
Time: O(k+l), two lists and O(n) for traversal ---> O(n)
Space: O(n)
Executed Successfully on Leet: Yes
*/

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap <String,List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            String str = wordsDict[i];
            if (str.equals(word1)){
                if (!hm.containsKey(word1)){
                    hm.put(word1, new ArrayList<>());
                }
                hm.get(word1).add(i);
            }
            if (str.equals(word2)){
                if (!hm.containsKey(word2)){
                    hm.put(word2, new ArrayList<>());
                }
                hm.get(word2).add(i);
            }
        }
        
        System.out.println(hm);
        
        int res = Integer.MAX_VALUE;
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        int i = 0, j = 0;
        
        while ((i < l1.size()) && (j < l2.size())){
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)){
                i++;
            }
            else{
                j++;
            }
        }
        
        return res;
    }
}
