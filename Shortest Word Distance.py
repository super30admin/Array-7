class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # Time O(n)
        # Space O(1)
        w1 = -1
        w2 = -1
        dist = float('inf')
        lenn = len(wordsDict)
        i = 0
        while i < lenn:
            word = wordsDict[i]
            if word == word1:
                w1 = i
            if word == word2:
                w2 = i
            if w1 != -1 and w2 != -1:
                dist = min(dist, abs(w1 - w2))
            i += 1

        return dist


