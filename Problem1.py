#Time Complexity: O(N)
#Space Complexity: O(1)
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        minn = float('inf')
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                p1 = i
            elif wordsDict[i] == word2:
                p2 = i
            if p1 != -1 and p2 != -1:
                minn = min(minn, abs(p2-p1))
            if minn == 1:
                return minn
        return minn