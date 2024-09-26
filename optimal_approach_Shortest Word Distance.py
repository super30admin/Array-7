#time: O(n)
#space: O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        if(wordsDict==None or len(wordsDict)==0):
            return 0
        mind=float("inf")
        id1=-1
        id2=-1
        for i in range(len(wordsDict)):
            if(wordsDict[i]==word1):
                id1=i
            elif(wordsDict[i]==word2):
                id2=i
            if(id1!=-1 and id2!=-1):
                mind=min(mind,abs(id1-id2))
                
                
            
        return mind