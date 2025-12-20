"""
If word1 and word2 are equal, then we need to update the first and seconds pointers as  
    - When we find the word, we update first to the previous value of second, and second to the current index.
    - This ensures we always compare with the most recent occurrence of the same word.
    
Time Complexity: O(n)
Space Complexity: O(1)
"""
from typing import List

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        minDist = len(wordsDict)
        first = -1
        second = -1
        for i in range(len(wordsDict)):
            if word1 == word2:
                if word1 == wordsDict[i]:
                    first = second
                    second = i
            else:
                if wordsDict[i] == word1:
                    first = i
                elif wordsDict[i] == word2:
                    second = i
            if first != -1 and second != -1 and first != second:
                minDist = min(abs(first - second), minDist)

        return minDist