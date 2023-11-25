class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        ## T.C = O(n)
        ## S.C = O(1)
        
        idx1 = -1
        idx2 = -1
        mn = float('inf')

        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                idx1 = i
            if wordsDict[i] == word2:
                if idx1 == i:
                    idx1 = idx2    
                idx2 = i
            if idx1 != -1 and idx2 != -1:
                mn = min(mn, abs(idx1 - idx2))
        
        return mn