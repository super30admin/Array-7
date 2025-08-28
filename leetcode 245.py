"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        index1 = index2 = -1
        min_dist = float('inf')

        for i, word in enumerate(wordsDict):
            if word == word1 == word2:
                if index1 != -1:
                    min_dist = min(min_dist, i - index1)
                index1 = i
            elif word == word1:
                if index2 != -1:
                    min_dist = min(min_dist, i - index2)
                index1 = i
            elif word == word2:
                if index1 != -1:
                    min_dist = min(min_dist, i - index1)
                index2 = i

        return min_dist