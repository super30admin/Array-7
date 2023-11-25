class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        ## T.C = O(n)
        ## S.C = O(1)

        p1, p2 = -1, -1
        mn = float('inf')

        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                p1 = i
            if wordsDict[i] == word2:
                p2 = i
            if p1 != -1 and p2 != -1:
                mn = min(mn, abs(p1-p2))
        
        return mn