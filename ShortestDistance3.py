#If both words are the same, store the prev index of j in i and proceed as before
# TC: O(n)
# SC: O(1)
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        i = -1
        j = -1
        result = float('inf')
        for w in range(0, len(wordsDict)):
            if wordsDict[w]==word1:
                i = w
            if wordsDict[w] == word2:
                if word1 == word2:
                    i = j
                j = w
            if i != -1 and j != -1:
                result = min(result, abs(j-i))
            
        return result
