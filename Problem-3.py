"""
TC: O(n)
SC: O(1)
"""
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        min_ = float('inf')
        ptr1 = -1
        ptr2 = -1
        
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                ptr1 = i
            
            if wordsDict[i] == word2:
                if ptr1 == i: # swap pointers when word1 and word2 are same
                    ptr1 = ptr2
                ptr2 = i
            
            if ptr1 != -1 and ptr2 != -1:
                min_ = min(min_, abs(ptr1 - ptr2))
        return min_
        