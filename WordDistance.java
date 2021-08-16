class WordDistance {
    
    //map to store word and its indexes
    HashMap<String, ArrayList<Integer>> map;
    
        public WordDistance(String[] wordsDict) {
        
        //initializing map
        map = new HashMap<>();
        
        //creating map of word and list of indexes where these words exist
        for(int i=0; i<wordsDict.length; i++){
            
            //if word doesn't exist in map
            if(!map.containsKey(wordsDict[i])){
                //add to map
                map.put(wordsDict[i], new ArrayList<>());
            }
            //add index of word to map
            map.get(wordsDict[i]).add(i);
        }
    }
    
    //time: O(max(m,n)) where m= length of word1, n=length of word2
    //space: O(1), everything created in constructor. Nothing new created here.
    public int shortest(String word1, String word2) {
        
        //get the list of indexs for the two words
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        
        //index to keep track of l1 and l2
        int i1 = 0, i2= 0;
        
        //variable to store min distance
        int min = Integer.MAX_VALUE;
        
        //until one of the list runs out
        while(i1<l1.size() && i2<l2.size()){
            
            //update the min
            min = (Math.min(min, Math.abs(l1.get(i1)-l2.get(i2))));
            
            //update index of li and l2
            if(l1.get(i1) <= l2.get(i2)){
                i1++;
            }
            else{
                i2++;
            }
        }
        return min;
    }
}

