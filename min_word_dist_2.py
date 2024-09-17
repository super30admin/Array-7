# Time Complexity : O(n + m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

from collections import defaultdict


class WordDistance:

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.positions = defaultdict(list)

        # prepare a mapping from a word to all it's positions (indices).
        for i, w in enumerate(words):
            self.positions[w].append(i)

    def shortest(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        pos1, pos2 = self.positions[word1], self.positions[word2]
        l1, l2 = 0, 0
        min_diff = float("inf")

        # until the shorter of the two lists is processed
        while l1 < len(pos1) and l2 < len(pos2):
            min_diff = min(min_diff, abs(pos1[l1] - pos2[l2]))

            if pos1[l1] < pos2[l2]:
                l1 += 1

            else:
                l2 += 1

        return min_diff


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
