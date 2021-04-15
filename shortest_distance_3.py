# Similar to part 1 - words are duplicate and we want shortest distance
# Time - O(N)
# Space - O(1)

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:

        idx1 = -1
        idx2 = -1
        result = float("inf")
        
        for i in range(len(wordsDict)):
            
            if wordsDict[i] == word1:
                idx1 = i
                
            if wordsDict[i] == word2:
                if idx1 == i:
                    idx1 = idx2
                    
                idx2 = i 
            
            if idx1 != -1 and idx2 !=-1:
                
                result = min(result, abs(idx1-idx2))
                
        return result
                
        
        
        
        
       