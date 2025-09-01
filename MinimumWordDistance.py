from typing import List
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1,p2 = -1,-1
        res = float("inf")
        n = len(wordsDict)
        for i in range(n):
            w = wordsDict[i]
            if w == word1:
                p1 = i
            if w == word2:
                p2 = i
            if p1!=-1 and p2!=-1:
                res = res if res <abs(p1-p2) else abs(p1-p2)
        return res
        