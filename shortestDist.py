"""
Keep track of the most recent index of each target word while scanning the list once
Each time you encounter one, compute the distance to the last seen index of the other
Keep the minimum of all distances seen — that’s the answer
"""
"""
Time Complexity: O(n) single pass
Space Complexity: O(1)
"""

from typing import List

class shortestDist:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
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

s = shortestDist()
print(s.shortestDistance(["practice","makes","perfect","coding","makes"], "coding", "practice"))  # 3
print(s.shortestDistance(["practice","makes","perfect","coding","makes"], "makes", "coding"))     # 1
