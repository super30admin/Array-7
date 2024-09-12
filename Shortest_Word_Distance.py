class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        word1_index = -1
        word2_index = -1
        result = float('inf')
        
        for i in range(len(wordsDict)):
            if word1 == wordsDict[i]:
                word1_index = i
            if word2 == wordsDict[i]:
                word2_index = i
            if word1_index !=-1 and word2_index != -1:
                result = min(result, abs(word1_index - word2_index))
        
        return result
