// Time Complexity : O(n), n -> Number of words
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

public class ShortestWordDistanc3 {
	/********************* 2 Pointers *********************/
	public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
		if (wordsDict == null || wordsDict.length == 0) {
			return 0;
		}

		int p1 = -1;
		int p2 = -1;
		int minDist = wordsDict.length;

		for (int i = 0; i < wordsDict.length; i++) {
			if (wordsDict[i].equals(word1)) {
				p1 = i;
			}

			if (wordsDict[i].equals(word2)) {
				if (p1 == i) {
					p1 = p2;
				}
				p2 = i;
			}

			if (p1 != -1 && p2 != -1) {
				minDist = Math.min(minDist, Math.abs(p1 - p2));
			}
		}

		return minDist;
	}

	public static void main(String[] args) {
		ShortestWordDistanc3 obj = new ShortestWordDistanc3();
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		String word1 = "makes";
		String word2 = "makes";

		System.out.println("Shortest Distance between \'" + word1 + "\' and \'" + word2 + "\' is "
				+ obj.shortestWordDistance(words, word1, word2));
	}

}
