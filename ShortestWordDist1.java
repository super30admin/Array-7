/*
        //TC : O(N)  and SC : O(1)
        ////AS we are iterating over wordDict in linear time


        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< wordsDict.length; i++){
            if(word1.equals(wordsDict[i]) ){
                p1 = i;
            }
            if(word2.equals(wordsDict[i]) ){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1){
                min = Math.min(Math.abs(p2 - p1), min);
            }
        }
        
        return min;
        
*/ 
        



 //TC : O(n + m ) - Iterating over lists of size n and m where n and m is size of list (of indices ) for word1 and word2 
//SC : O(N) as we are using hashmap 
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
      
       
        HashMap<String, List<Integer> > map = new HashMap<>();
        
        for(int i = 0; i< wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            
            map.get(wordsDict[i]).add(i);
        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1 < l1.size() && p2 < l2.size()){
            int i1 = l1.get(p1);
            int i2 = l2.get(p2);
            
            min = Math.min(min, Math.abs(i2-i1));
            
            if(i1 < i2) p1++;
            else
                p2++;
        }
        
        return min;
    }
}