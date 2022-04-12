class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        #O(N*K) time , K avg length of the word, and O(1) space solution
        if wordsDict == None or len(wordsDict) == 0:
            return 0
        i1 = -1
        i2 = -1
        minimumDistance = 99999
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                i1 = i
            if wordsDict[i] == word2:
                i2 = i
            
            if i1 != -1 and i2 != -1:
                minimumDistance = min(minimumDistance, abs(i1 - i2))
        
        return minimumDistance
                