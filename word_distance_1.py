# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        word1_idx = -1
        word2_idx = -1
        p = 2**32
        for i, word in enumerate(wordsDict):
            if word1 == word:
                word1_idx = i
            if word2 == word:
                word2_idx = i
            if word2_idx != -1 and word1_idx != -1:
                p = min(p, abs(word2_idx - word1_idx))
        return p
