class ShortestDistance1 {
  /**
   * 
   * Time Complexity: O(n * k)
   *  n -> wordsDict.length
   *  k -> average length of the words in dict
   * 
   * Space complexity: O(1)
   * 
   * Were you able to solve this on leetcode? Yes
   */
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
    int ptr1 = -1, ptr2 = -1;
    int res = Integer.MAX_VALUE;
    
    for(int i = 0; i < wordsDict.length; i++){
        if(wordsDict[i].equals(word1)){
            ptr1 = i;
        } else if (wordsDict[i].equals(word2)){
            ptr2 = i;
        }
        
        if(ptr1 != -1 && ptr2 != -1) res = Math.min(res, Math.abs(ptr1 - ptr2));

    }
    
    return res;
}
}