# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Similar to problem I, but word1 and word2 can be the same.
# If words are the same, track previous occurrence.

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        pos1 = pos2 = -1
        res = float('inf')
        
        for i, word in enumerate(wordsDict):
            
            if word == word1:
                
                if word1 == word2:
                    pos1 = pos2
                    pos2 = i
                else:
                    pos1 = i
            
            elif word == word2:
                pos2 = i
            
            if pos1 != -1 and pos2 != -1:
                res = min(res, abs(pos1-pos2))
        
        return res