"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        index1, index2 = -1, -1
        min_dist = float('inf')
        
        for i, word in enumerate(wordsDict):
            if word == word1:
                index1 = i
                if index2 != -1:
                    min_dist = min(min_dist, abs(index1 - index2))
            elif word == word2:
                index2 = i
                if index1 != -1:
                    min_dist = min(min_dist, abs(index1 - index2))
        
        return min_dist