TC: O(n)
SC: O(n)

Approach: Using a hashmap we can access the index of the words as values in list form in O(1) time.AFter getting the indices as list
we can find the minimum distance between the indices in the two list using a two pointer method as both the list are sorted.


class WordDistance {

    HashMap<String, List<Integer>> hashMap;
    public WordDistance(String[] words) {
        
        hashMap = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(hashMap.containsKey(word)){
                hashMap.get(word).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(word, list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1= hashMap.get(word1);
        List<Integer> w2= hashMap.get(word2);
        
        int min_dist= Integer.MAX_VALUE;
        
        int i1;
        int i2;
        int i=0, j=0;
        
        while(i< w1.size() && j<w2.size()){
            i1=w1.get(i);
            i2=w2.get(j);
            
            min_dist = Math.min(min_dist, Math.abs(i1-i2));
            
            if(i2>i1) i+=1;
            else  j+=1;
            
        }
        return min_dist;        
            
        
    }
