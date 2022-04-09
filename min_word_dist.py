# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def shortestDistance(self, wordsDict, word1, word2):
        """
        :type wordsDict: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        min_dist = len(wordsDict) + 1

        # pointers
        i1 = None
        i2 = None

        for i, word in enumerate(wordsDict):
            if word == word1 or word == word2:

                if i2 is not None:
                    if word != i2:
                        min_dist = min(min_dist, i - i1)

                i2 = word
                i1 = i

        return min_dist
