"""
Preprocess: map each word - a sorted list of indices where it appears
For a query (w1, w2), run a two-pointer merge over their index lists to find the minimum gap
This makes each query fast while preprocessing once
"""
"""
Preprocess: O(n) time, O(n) space
Per query: O(m + n) where m, n are counts of word1, word2 (often much smaller than array length)
"""

from collections import defaultdict
from typing import List

class WordDistance:
    def __init__(self, wordsDict: List[str]):
        self.pos = defaultdict(list)
        for i, w in enumerate(wordsDict):
            self.pos[w].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        A, B = self.pos[word1], self.pos[word2]
        i = j = 0
        best = float('inf')
        while i < len(A) and j < len(B):
            best = min(best, abs(A[i] - B[j]))
            if A[i] < B[j]:
                i += 1
            else:
                j += 1
        return best

if __name__ == "__main__":
    words = ["practice", "makes", "perfect", "coding", "makes"]
    wd = WordDistance(words)
    print(wd.shortest("coding", "practice")) 
    print(wd.shortest("makes", "coding"))    
    print(wd.shortest("practice", "perfect")) 