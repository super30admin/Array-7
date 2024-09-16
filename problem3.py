#Time O(n),space O(1)
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        w1=-1
        w2=-1        
        d=len(wordsDict)
        
        for i in range(len(wordsDict)):
            
            if wordsDict[i]==word1:
                w1=i
                
                if word1==word2:
                    w1=w2
            if wordsDict[i]==word2:
                w2=i
                
                
            if w1!=-1 and w2!=-1:
                d=min(d,abs(w1-w2))
                
        return d
