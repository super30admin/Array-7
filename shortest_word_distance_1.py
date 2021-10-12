#Time Complexity : O(N)  #N is words in dictionary
#Space Complexity : O(1) 
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        mind = float('inf')
        for index,s in enumerate(wordsDict):
            if s == word1:
                p1 = index
            elif s == word2:
                p2 = index
            
            if p1 !=-1 and p2!=-1:
                mind = min(mind,abs(p1-p2))
        return mind