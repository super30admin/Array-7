// Time Complexity : O(m*n)
// Space Complexity : O(1) // map is in constructor 
// Did this code successfully run on Leetcode : NO, Premium question
// Any problem you faced while coding this : No

HashMap<String, List<Integer>> map;
public void wordDistance(String wordDict[]){
    if(wordDict == null || wordDict.length ==0){
        return;
    }
    map = new HashMap<>();

    for(int i =0; i<wordDict.length; i++){
        String word = wordDict[i];
        if(!map.containsKey(word)){
            map.put(word, new LinkedList());
        }
        map.get(word).add(i);
    }

}

public int shortest(String word1, String word2){
    List<Integer> l1 = map.get(word1);
    List<Integer> l2 = map.get(word2);
    int minDist = Integer.MIN_VALUE;

    int p1 = 0;
    int p2 = 0;

    while(p1<l1.size() && p2<l2.size()){
        int index1 = l1.get(p1);
        int index2 = l2.get(p2);

        minDist = Math.min(minDist, Math.abs(index1 - index2));
        if(index1 < index2){
            p1++;
        }
        else{
            p2++;
        }
    }
    return minDist;
}