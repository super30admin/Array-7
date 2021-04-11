#time: O(n^2)
#space: O(1)
#brute force
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        if(wordsDict==None or len(wordsDict)==0):
            return 0
        mind=float("inf")
        for i in range(len(wordsDict)):
            if (wordsDict[i]==word1):
                for j in range(len(wordsDict)):
                    if (wordsDict[j]==word2):
                        mind=min(mind,abs(j-i))
        return mind