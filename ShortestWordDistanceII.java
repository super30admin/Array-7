import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(p+q) where p = number of occurences of word1, q = number of occurences of word2
//Space Complexity : O(n) where n = length of wordsDict array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//244. Shortest Word Distance II (Medium) - https://leetcode.com/problems/shortest-word-distance-ii/description/
//Time Complexity : O(p+q) where p = number of occurences of word1, q = number of occurences of word2
//Space Complexity : O(n) where n = length of wordsDict array
class WordDistance {

	HashMap<String, List<Integer>> map;

	public WordDistance(String[] wordsDict) {
		this.map = new HashMap<>();
		for (int i = 0; i < wordsDict.length; i++) { // O(n)
			String word = wordsDict[i];
			// map.put(word, map.getOrDefault(word, new ArrayList<>()).add(i));

			if (!map.containsKey(word)) {
				map.put(word, new ArrayList<>());
			}
			map.get(word).add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);

		int min = Integer.MAX_VALUE;
		int p1 = 0, p2 = 0;

		while (p1 < list1.size() && p2 < list2.size()) { // O(p+q)
			int index1 = list1.get(p1);
			int index2 = list2.get(p2);

			min = Math.min(min, Math.abs(index1 - index2));
			if (min == 1)
				return min;

			if (index1 < index2)
				p1++;
			else
				p2++;
		}

		return min;
	}
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict); int param_1 =
 * obj.shortest(word1,word2);
 */