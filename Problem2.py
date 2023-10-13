#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class WordDistance:
    #Time Complexity :O(n)
    #Space Complexity :O(n)
    def __init__(self, wordsDict: List[str]):
        self.map={}
        for i in range(len(wordsDict)):
            if wordsDict[i] not in self.map.keys():
                self.map[wordsDict[i]]=[]
            self.map[wordsDict[i]].append(i)
            
    #Time Complexity :O(k1+k2) where k1=size of l1  and k2=size of l2, worst case O(n)
    #Space Complexity :O(1)
    def shortest(self, word1: str, word2: str) -> int:
        li1=self.map.get(word1)
        li2=self.map.get(word2)
        p1=0
        p2=0
        minVal=float('inf')
        while p1<len(li1) and p2<len(li2):
            if li1[p1]<li2[p2]:
                minVal=min(minVal,li2[p2]-li1[p1])
                p1+=1
            else:
                minVal=min(minVal,li1[p1]-li2[p2])
                p2+=1
        return minVal


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)