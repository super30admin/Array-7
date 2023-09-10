class WordDistance {
    HashMap<String,List<Integer>> wordsDictMap; 

    public WordDistance(String[] wordsDict) {
        this.wordsDictMap=new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(!wordsDictMap.containsKey(wordsDict[i]))
                wordsDictMap.put(wordsDict[i],new ArrayList<>());
            wordsDictMap.get(wordsDict[i]).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1=wordsDictMap.get(word1);
        List<Integer> w2=wordsDictMap.get(word2);
        int i=0;
        int j=0;
        int diff=Integer.MAX_VALUE;
        while(i<w1.size() && j<w2.size()){
            if(w1.get(i)<w2.get(j)){
                diff=Math.min(diff,w2.get(j)-w1.get(i));
                i++;
            }
            else{
                diff=Math.min(diff,w1.get(i)-w2.get(j));
                j++;
            }
        }
        return diff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
