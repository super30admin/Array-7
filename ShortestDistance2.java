//time complexity: O(n)
//space complexity: O(1)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {
    HashMap<String,List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map=new HashMap<>();
        for(int i=0;i<wordsDict.length;i++)
        {
            if(map.get(wordsDict[i])==null)
                map.put(wordsDict[i],new ArrayList<Integer>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> arr1=map.get(word1);
        List<Integer> arr2=map.get(word2);
        int p1=0;
        int p2=0;
        int max=Integer.MAX_VALUE;
        while(p1!=arr1.size() && p2!=arr2.size())
        {
            int ele1=arr1.get(p1);
            int ele2=arr2.get(p2);
            int diff=Math.abs(ele1-ele2);
            max=Math.min(diff,max);
            if(ele1>ele2)
                p2+=1;
            else
                p1+=1;
            
        }
        return max;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */