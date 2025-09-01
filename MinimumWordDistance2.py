import collections
from typing import List
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.wordmap = collections.defaultdict(list)
        for i in range(len(wordsDict)):
            word = wordsDict[i]
            self.wordmap[word].append(i)
        

    def shortest(self, word1: str, word2: str) -> int:
        l1 = self.wordmap[word1]
        l2 = self.wordmap[word2]
        p1,p2 = 0,0
        res = float("inf")
        while p1<len(l1) and p2<len(l2):
            if l1[p1]<l2[p2]:
                res = res if res < abs(l1[p1]-l2[p2]) else abs(l1[p1]-l2[p2])
                p1+=1
            else:
                res = res if res < abs(l1[p1]-l2[p2]) else abs(l1[p1]-l2[p2])
                p2+=1
        return res

        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)