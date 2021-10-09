// Time Complexity : O(n + k + m), n -> Number of words, k -> Length of indices list of word1, m -> Length of indices list of word2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {
	Map<String, List<Integer>> wordMap;

	/********************* HashMap *********************/
	public ShortestWordDistance2(String[] wordsDict) {
		wordMap = new HashMap<>();

		for (int i = 0; i < wordsDict.length; i++) {
			if (!wordMap.containsKey(wordsDict[i])) {
				wordMap.put(wordsDict[i], new ArrayList<>());
			}
			wordMap.get(wordsDict[i]).add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = wordMap.get(word1);
		List<Integer> list2 = wordMap.get(word2);

		int m = list1.size();
		int n = list2.size();

		int i = 0;
		int j = 0;
		int minDist = Integer.MAX_VALUE;

		while (i < m && j < n) {
			int val1 = list1.get(i);
			int val2 = list2.get(j);

			minDist = Math.min(minDist, Math.abs(val1 - val2));

			if (val1 < val2) {
				i++;
			} else {
				j++;
			}
		}

		return minDist;
	}

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		ShortestWordDistance2 obj = new ShortestWordDistance2(words);
		
		System.out.println(
				"Shortest Distance between \'coding\' and \'practice\' is " + obj.shortest("coding", "practice"));

		System.out.println(
				"Shortest Distance between \'coding\' and \'practice\' is " + obj.shortest("coding", "practice"));

		System.out.println("Shortest Distance between \'makes\' and \'coding\' is " + obj.shortest("makes", "coding"));
	}

}
