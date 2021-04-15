# approach - update indices when we find words 
# Return min distance recorded so far

# Time - O(N)
# Space - O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        idx1 = -1
        idx2 = -1
        result = float("inf")
        
        for idx, word in enumerate(wordsDict):
            
            if word == word1:
                idx1 = idx
                
            elif word == word2:
                idx2 = idx
            
            
            if idx1 != -1 and idx2 != -1:
                result = min(result, abs(idx1-idx2))
                
        return result
                
                
        