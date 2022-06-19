import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Time Complexity: O(min(m,k)); where n is total no. of words and m,k are frequency of word1 and word2 in dictionary.
//Space Complexity: O(n)

public class ShortestWordDistance_II { 
	/**Approach: HashMap + Two Pointers**/
	HashMap<String, List<Integer>> map;
    public ShortestWordDistance_II(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int p1= 0; int p2= 0;
        int dist = Integer.MAX_VALUE;
        while(p1<l1.size() && p2<l2.size()){  
            int idx1 = l1.get(p1);
            int idx2 = l2.get(p2);  
            if(dist == 1) break;//optimization
            dist = Math.min(dist, Math.abs(idx1 - idx2));
            if(idx1 < idx2){
                p1++;
            }else{
                p2++;
            }
        }
        return dist;
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {	
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes", "practice"};
		ShortestWordDistance_II ob  = new ShortestWordDistance_II(wordsDict);	
				
		System.out.println("Shortest distance between words is: "+ ob.shortest("coding", "practice"));         
		System.out.println("Shortest distance between words is: "+ ob.shortest("makes", "coding"));         
	}	
}
