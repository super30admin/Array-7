#TC: O(n)
#SC: O(1)
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        i = -1
        j = -1
        result = float('inf')
        for w in range(0, len(wordsDict)):
            if wordsDict[w]==word1:
                i = w
            elif wordsDict[w] == word2:
                j = w
            if i != -1 and j != -1:
                result = min(result, abs(j-i))
            
        return result
