class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # Time O(n)
        # Space O(1)
        dist = float('inf')
        w1 = -1
        w2 = -1
        i = 0
        while i < len(wordsDict):
            word = wordsDict[i]
            if word == word1:
                if word1 == word2:
                    w2 = w1
                w1 = i
            if word == word2:
                if w1 != i:
                    w2 = i
            if w1 != w2 and w1 != -1 and w2 != -1:
                dist = min(dist, abs(w2-w1))
            i += 1
        return dist