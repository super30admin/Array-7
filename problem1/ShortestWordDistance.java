// Time Complexity : O(n), n -> Number of words
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class ShortestWordDistance {
	/********************* 2 Pointers *********************/
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
		if (wordsDict == null || wordsDict.length == 0) {
			return 0;
		}

		int p1 = -1;
		int p2 = -1;

		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < wordsDict.length; i++) {
			if (wordsDict[i].equals(word1)) {
				p1 = i;
			} else if (wordsDict[i].equals(word2)) {
				p2 = i;
			}

			if (p1 != -1 && p2 != -1) {
				minDist = Math.min(minDist, Math.abs(p1 - p2));
			}
		}

		return minDist == Integer.MAX_VALUE ? 0 : minDist;
	}

	public static void main(String[] args) {
		ShortestWordDistance obj = new ShortestWordDistance();
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		String word1 = "coding";
		String word2 = "practice";

		System.out.println("Shortest Distance between \'" + word1 + "\' and \'" + word2 + "\' is "
				+ obj.shortestDistance(words, word1, word2));
	}

}
