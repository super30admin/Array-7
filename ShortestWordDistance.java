//Time Complexity: O(n); where n is number of words in wordsDict.
//Space Complexity: O(1)

public class ShortestWordDistance { 
	/**Approach: Two Pointers**/
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1= -1;
        int p2= -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++){
            String word = wordsDict[i];            
            if(word.equals(word1)) p1= i;            
            if(word.equals(word2)) p2 = i;            
            if(dist == 1) break;//optimization            
            if(p1 != -1 && p2 != -1){
                dist = Math.min(dist, Math.abs(p1-p2));
            }
        }        
        return dist;
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {	
		ShortestWordDistance ob  = new ShortestWordDistance();	
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
		
		System.out.println("Shortest distance between words is: "+ ob.shortestDistance(wordsDict, "coding", "practice"));         
	}	
}
