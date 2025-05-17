import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//SC; O(n)
//TC: O(logn)
class ShortestWordDistanceII {
  Map<String,List<Integer>> map;
  public ShortestWordDistanceII(String[] wordsDict) {
      map=new HashMap<>();
		for(int i=0;i<wordsDict.length;i++) {
			String curr=wordsDict[i];
			if(!map.containsKey(curr)) {
				map.put(curr, new ArrayList<>());
			}
			map.get(curr).add(i);
		}
  }
  
  public int shortest(String word1, String word2) {
      List<Integer> l1=map.get(word1);
		List<Integer> l2=map.get(word2);
		int p1=0;
		int p2=0;
		int res=Integer.MAX_VALUE;
		while(p1<l1.size() && p2<l2.size()) {
			
			res=Math.min(res, Math.abs(l1.get(p1)-l2.get(p2)));
			if(l1.get(p1)<l2.get(p2)) {
				p1++;
			}else {
				p2++;
			}
			
		}
		return res;
  }
}

/**
* Your WordDistance object will be instantiated and called as such:
* WordDistance obj = new WordDistance(wordsDict);
* int param_1 = obj.shortest(word1,word2);
*/