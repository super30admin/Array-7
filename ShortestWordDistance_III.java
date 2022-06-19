//Time Complexity: O(n); where n is number of words in wordsDict.
//Space Complexity: O(1)

public class ShortestWordDistance_III { 
	/**Approach: Sliding window**/
	public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1= -1; int p2= -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++){
            String word = wordsDict[i];
            if(dist == 1) break;//optimization     
            if(word.equals(word1)) p1= i;            
            if(word.equals(word2)) {
                if(p1 == i){ // can happen only when both words are same.
                    p1 = p2;   
                }
                p2 = i;          
            }        
            if(p1 != -1 && p2 != -1){
                dist = Math.min(dist, Math.abs(p1 - p2));              
            }
        }
        return dist;
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		ShortestWordDistance_III ob  = new ShortestWordDistance_III();	
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes", "practice"};
				
		System.out.println("Shortest distance between words is: "+ ob.shortestWordDistance(wordsDict, "makes", "coding"));    
		//System.out.println("Shortest distance between words is: "+ ob.shortestWordDistance(wordsDict, "makes","makes"));
	}	
}
