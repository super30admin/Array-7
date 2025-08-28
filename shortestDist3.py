"""
If word1 != word2, scan once and track the latest indices of each; update the min gap on every hit
If word1 == word2, we need the closest pair of consecutive occurrences of that same word—track the previous index and minimize i - prev
One linear pass, constant space
"""
"""
Time Complexity: O(n)
Space Complexity: O(1)
"""

from typing import List

class shortestDist3:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        if word1 == word2:
            prev = -1
            best = float('inf')
            for i, w in enumerate(wordsDict):
                if w == word1:
                    if prev != -1:
                        best = min(best, i - prev)
                    prev = i
            return best

        i1 = i2 = -1
        best = float('inf')
        for i, w in enumerate(wordsDict):
            if w == word1:
                i1 = i
                if i2 != -1:
                    best = min(best, i1 - i2 if i1 > i2 else i2 - i1)
            elif w == word2:
                i2 = i
                if i1 != -1:
                    best = min(best, i2 - i1 if i2 > i1 else i1 - i2)
        return best

s = shortestDist3()
print(s.shortestWordDistance(["practice","makes","perfect","coding","makes"], "makes", "coding"))  # 1
print(s.shortestWordDistance(["practice","makes","perfect","coding","makes"], "makes", "makes"))   # 3 
print(s.shortestWordDistance(["a","a","b","a"], "a", "a"))                                        # 1
