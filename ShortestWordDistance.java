import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n*k) where n = length of wordsDict array, k = average length of word
//Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//243. Shortest Word Distance (Easy) - https://leetcode.com/problems/shortest-word-distance/description/
//Time Complexity : O(n) where n = length of wordsDict array
//Space Complexity : O(1)
class Solution {
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
		if (wordsDict == null || wordsDict.length == 0)
			return 0;

		int i1 = -1, i2 = -1, min = wordsDict.length;

		for (int i = 0; i < wordsDict.length; i++) { // O(n)
			String word = wordsDict[i];

			if (word.equals(word1))
				i1 = i;
			if (word.equals(word2))
				i2 = i;

			if (i1 != -1 && i2 != -1) {
				min = Math.min(min, Math.abs(i1 - i2));
			}
		}

		return min;
	}
}