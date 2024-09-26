public class ShortestDistance3 {
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
  
  public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    int ptr1 = -1, ptr2 = -1;
    int res = Integer.MAX_VALUE;
    
    if(word1.equals(word2)){
        for(int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)){
                if(ptr1 < ptr2) {
                    ptr1 = i;
                } else {
                    ptr2 = i;
                }
                
                if(ptr1 != -1 && ptr2 != -1) res = Math.min(res, Math.abs(ptr1 - ptr2));
            }
        }
        return res;
    }
    
    for(int i = 0; i < wordsDict.length; i++){
        if(wordsDict[i].equals(word1)){
            ptr1 = i;
        } else if (wordsDict[i].equals(word2)){
            ptr2 = i;
        }
        
        // if()
        if(ptr1 != -1 && ptr2 != -1) res = Math.min(res, Math.abs(ptr1 - ptr2));

    }
    
    return res;
  }
}
