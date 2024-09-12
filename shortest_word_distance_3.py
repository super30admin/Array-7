#Time Complexity : O(N)  #  N is len(wordsDict)
#Space Complexity : O(1) 
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        mind = float('inf')
        for index,s in enumerate(wordsDict):
            if s == word1:
                p1 = index
            if s == word2:
                if p1 == index:
                    p1 = p2
                p2 = index
            
            if p1 !=-1 and p2!=-1:
                mind = min(mind,abs(p1-p2))
        return mind
        

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        mind = float('inf')
        for index,s in enumerate(wordsDict):
            if word1 != word2 :
                if s == word1:
                    p1 = index
                if s == word2:
                    p2 = index
            else:
                if s == word2:
                    if p1 <= p2 :
                        p1 = index
                    else:
                        p2 = index


                    
            if p1 !=-1 and p2!=-1:
                mind = min(mind,abs(p1-p2))
        return mind
        