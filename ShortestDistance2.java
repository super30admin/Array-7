public class ShortestDistance2 {

  /**
   * Time Complexity: O(n)
   * 
   * Space Complexity: O(1)
   * 
   * Were you able to solve this on leetcode? Yes
   */

  Map<String, List<Integer>> map;
    
  public WordDistance(String[] wordsDict) {
      map = new HashMap<>();
      
      for(int i = 0; i < wordsDict.length; i++){
          List<Integer> list = map.getOrDefault(wordsDict[i], new ArrayList<>());
          
          list.add(i);
          map.put(wordsDict[i], list);
      }
  }
  
  public int shortest(String word1, String word2) {
      List<Integer> list1 = map.get(word1);
      
      List<Integer> list2 = map.get(word2);
      
      int ptr1 = 0, ptr2 = 0;
      
      int minDist = Integer.MAX_VALUE;
      
       while(ptr1 < list1.size() && ptr2 < list2.size()){
           int index1 = list1.get(ptr1);
           int index2 = list2.get(ptr2);
           
           minDist = Math.min(minDist, Math.abs(index1 - index2));
           
           if(index1 < index2){
               ptr1++;
           } else {
               ptr2++; 
           }
       }
      
      return minDist;
  }
}
