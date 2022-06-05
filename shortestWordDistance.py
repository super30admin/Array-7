class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        i1 , i2 = -1, -1
        dist = float("inf")
        for i in range(len(wordsDict)):
            if word1 != word2 :
                if wordsDict[i] == word1:
                    i1 = i 
                if wordsDict[i] == word2:
                    i2 = i 
            else:
                if wordsDict[i] == word1:
                    if i1 < i2:
                        i1 = i 
                    else:
                        i2 = i
            if i1 != -1 and i2 != -1:
                dist = min(dist, abs(i1-i2) )
        return dist
