package Array-7;
// TC: O(N)
// SC: O(N)
public class Problem2 {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            String word=wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int p1=0,p2=0,min=Integer.MAX_VALUE;
        while(p1<l1.size() && p2<l2.size()){
            if(l1.get(p1)<l2.get(p2)){
                min = Math.min(min, l2.get(p2)-l1.get(p1));
                p1++;
            }else{
                min = Math.min(min, l1.get(p1)-l2.get(p2));
                p2++;
            }
        }
        return min;
    }
}
