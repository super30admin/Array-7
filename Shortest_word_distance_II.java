class Solution{
  HashMap<String, List<Integer>> map;
    
  public WordDistance(String[] wordsDict){
      map = new HashMap<>();
      for(int i = 0; i < wordsDict; i++){
          if(!map.containsKey(wordsDict[i])){
              map.put(wordsDict[i], new ArrayList<>());
          }
          map.get(wordsDict([i]).add(i);
       }
  }
                  
  public int shortest(String word1, String word2){
      List<Integer> li1 = map.get(word1);
      List<Integer> li2 = map.get(word2);
      
      int i1 = 0;
      int i2 = 0;
      
      int min = Integer.MAX_VALUE;
      while(i1 < li1.size() && i2 < li2.size()){
          int index1 = li1.get(i1);
          int index2 = li2.get(i2);
          
          min = Math.min(min, Math.abs(index2 - index1));
          if(index1 < index2){
              i1++;
          }else{
              i2++;
          }
      }
      return min;
    }
  }
                  
//TC:O(m+k)
//SC: O(n)
                
        
                  
        
