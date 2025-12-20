"""
Approach 1: 2 pass, Everytime the first word is found in the list, find all occurances of second word and track minimum distance

Time Complexity: O(n^2) in worst case
Space Complexity: O(1)

Approach 2: 1 pass, Keep track of the most recent positions of word1 and word2 and update minimum distance as we go
Time Complexity: O(n)
Space Complexity: O(1)
"""
from typing import List

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        minDist = len(wordsDict)
        # for i in range(len(wordsDict)):
        #     if wordsDict[i] == word1:
        #         for j in range(len(wordsDict)):
        #             if wordsDict[j] == word2:
        #                 minDist = min(abs(j-i), minDist)
        # return minDist

        first = -1
        second = -1
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                first = i
            elif wordsDict[i] == word2:
                second = i
            if first != -1 and second != -1:
                minDist = min(abs(first - second), minDist)

        return minDist