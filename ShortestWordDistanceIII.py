'''
TC: O(n*m) where n is the number of words in a wordsDict and m is the length of words
SC: O(1) - since I am just using some pointers
'''
from typing import List

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        gmin = float('inf')
        if word1 != word2:
            i1 = i2 = None
            for i, word in enumerate(wordsDict):
                if word == word1:
                    i1 = i
                elif word == word2:
                    i2 = i
                if i1 is not None and i2 is not None:
                    gmin = min(gmin, abs(i1-i2))
        else:
            prev = None
            for i, word in enumerate(wordsDict):
                if word == word1:
                    if prev == None:
                        prev = i
                    else:
                        gmin = min(gmin, abs(prev - i))
                        prev = i
        return gmin if gmin != float('inf') else -1
s = Solution()
print(s.shortestWordDistance(["practice", "makes", "perfect", "coding", "makes"], "coding", "practice"))
print(s.shortestWordDistance(["practice", "makes", "perfect", "coding", "makes"], "makes", "coding"))
print(s.shortestWordDistance(["practice", "makes", "perfect", "coding", "makes"], "makes", "makes"))