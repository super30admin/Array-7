# 243. Shortest Word Distance
# https://leetcode.com/problems/shortest-word-distance/

# Logic: We have 2 pointers, each for one of the two search words. We change 
# pointers whenever we find a match. We calculate the distance between the 
# pointers and update min.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        w1 = -1
        w2 = -1
        
        minDist = inf
        
        for idx, i in enumerate(wordsDict):
            if i == word1:
                w1 = idx
            elif i == word2:
                w2 = idx
            
            if w1 != -1 and w2 != -1:
                minDist = min(minDist, abs(w1-w2))
        
        return minDist