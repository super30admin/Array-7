#time: O(n)
#space: O(m) where m is the no of occurance of the same word  
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        if(wordsDict==None or len(wordsDict)==0):
            return 0
        mind=float("inf")
        id1=-1
        id2=-1
        if(word1!=word2):
            for i in range(len(wordsDict)):
                if(wordsDict[i]==word1):
                    id1=i    
                if(wordsDict[i]==word2):
                    id2=i
                if(id1!=-1 and id2!=-1):
                    mind=min(mind,abs(id1-id2))
        else:
            idx=[]
            for i in range(len(wordsDict)):
                if(wordsDict[i]==word1):
                    idx.append(i)
            for i in range(1,len(idx)):
                mind=min(mind,idx[i]-idx[i-1])
                
            
        return mind