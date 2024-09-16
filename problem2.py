#Time O(m+n), space O(1)
class WordDistance: 
    def __init__(self, wordsDict: List[str]):
        self.h={}
        for i in range(len(wordsDict)):
            if wordsDict[i] not in self.h:
                self.h[wordsDict[i]]=[]
            self.h[wordsDict[i]].append(i)
        

    def shortest(self, word1: str, word2: str) -> int:
        wd1=self.h[word1]
        wd2=self.h[word2]
        d=float('inf')
        w1=0
        w2=0
        
        while w1<len(wd1) and w2 < len(wd2):
            d=min(d,abs(wd1[w1]-wd2[w2]))
            if wd1[w1]<wd2[w2]:
                w1+=1
            else:
                w2+=1
                
        return d
        
