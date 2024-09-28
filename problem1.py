# TC:O(n)
# SC:O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        if wordsDict is None:
            return None

        l1 = -1
        l2 = -1
        _min = sys.maxsize

        for i in range(0, len(wordsDict)):
            if wordsDict[i] == word1:
                l1 = i

            if wordsDict[i] == word2:
                l2 = i

            if l1 != -1 and l2 != -1:
                _min = min(abs(l1 - l2), _min)

        return _min


