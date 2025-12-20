"""
1. Improvising the iterative single pass approach using two pointers.
2. We store the indices of the words in a hash map and then use two pointers to find the minimum distance for all pairs.

Time Complexity: O(m + n) where m and n are the number of occurrences of word1 and word2 respectively.
Space Complexity: O(N) where N is the length of unique words in wordsDict
"""

from collections import defaultdict
from typing import List
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.len = len(wordsDict)
        self.hm = defaultdict(list)
        for i,word in enumerate(wordsDict):
            self.hm[word].append(i)
    
    def shortest(self, word1: str, word2: str) -> int:
        minDistance = self.len
        for first in self.hm[word1]:
            for second in self.hm[word2]:
                minDistance = min(minDistance, abs(first - second))
        return minDistance
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)