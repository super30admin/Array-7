class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1, p2 = -1, -1
        n = len(wordsDict)
        res = n 
        for i in range(n):
            if wordsDict[i] == word1:
                if word1 != word2 or p2 > p1:
                    p1 = i
            
            if wordsDict[i] == word2:
                if word1 != word2 or i != p1:
                    p2 = i

            if p1 != -1 and p2 != -1:
                res = min(res, abs(p1 - p2))
        return res