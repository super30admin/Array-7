# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        iw1,iw2 = -1,-1
        res = float('inf')

        for i in range(len(wordsDict)):
            word = wordsDict[i]
            if word == word1:
                iw1 = i
            if word == word2:
                iw2 = i
            if iw1 != -1 and iw2 != -1:
                res = min(res, abs(iw1-iw2))

        return res