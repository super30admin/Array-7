class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            String word = wordsDict[i];
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1list = map.get(word1);
        List<Integer> word2list = map.get(word2);
        int p1 = 0;
        int p2 = 0;
        int n1 = word1list.size();
        int n2 = word2list.size();
        int min = Integer.MAX_VALUE;
        while(p1<n1 && p2<n2){
            if(word1list.get(p1)<word2list.get(p2)){
                min = Math.min(min,word2list.get(p2)-word1list.get(p1));
                p1++;

                
            }else{
                min = Math.min(min,word1list.get(p1)-word2list.get(p2));
                p2++;
            }
        }
        return min;

    }
}

//TC------->O(m+n)
//SC------->O(m+n)