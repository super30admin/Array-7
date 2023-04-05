class Solution{
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    
    public int shortestWordDistanceII(String[] words, String word1, String word2){
        
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);           
        }
        
        int min = Integer.MAX_VALUE;
        
        List<Integer> li1 = map.get(word1);
        List<Integer> li2 = map.get(word2);
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < li1.size() && p2 < li2.size()){
            
            int val1 = li1.get(p1);
            int val2 = li2.get(p2);
            
            min = Math.min(min, Math.abs(val1-val2));
            
            if(val1 > val2){
                p2++;
            }
            else{
                p1++;
            } 
        }
        return min;
    }
}
