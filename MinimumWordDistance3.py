from typing import List
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1, p2 = -1, -1
        minVal = float("inf")
        for i in range(len(wordsDict)):
            word = wordsDict[i]
            if word1 == word2:
                if word == word1:
                    if p1<=p2:
                        p1=i
                    else:
                        p2=i
            else:
                if word == word1:
                    p1 = i
                if word == word2:
                    p2 = i
            if p1!=-1 and p2!=-1:
                minVal = minVal if abs(p1-p2) > minVal else abs(p1-p2)
        return minVal
        