#Time O(n),space O(1)

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
               
        w1=-1
        w2=-1
        d=float('inf')
        for i in range(len(wordsDict)):
            
            if wordsDict[i]==word1:
                w1=i
            if wordsDict[i]==word2:
                w2=i
                
            if w1!=-1 and w2!=-1:
                d=min(d,abs(w1-w2))
                
        return d
            
        
