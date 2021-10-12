#Time Complexity : O(M+N)  # M is len of list1 N is len(list2)
#Space Complexity : O(1) 
from collections import defaultdict
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.cmap = defaultdict(list)
        for index,word in enumerate(wordsDict):
            self.cmap[word].append(index)

    def shortest(self, word1: str, word2: str) -> int:
        l1 = self.cmap[word1]
        l2 = self.cmap[word2]
        m= len(l1)
        n = len(l2)
        p1 = 0
        p2 = 0 
        mind = float('inf')
        while(p1<m and p2 <n):
            val1 = l1[p1]
            val2 = l2[p2]
            mind = min(mind, abs(val1-val2))
            if val1 <= val2:
                p1+=1
            else:
                p2+=1
        return mind
            


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)