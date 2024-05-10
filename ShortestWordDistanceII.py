'''
TC: O(a+b) where a is the length of words in a wordsDict[worda] and b if the length of
            words in a wordsDict[wordb] + O(n) for iterating over the words and making 
            it into a dictionary but it can be ignored since it is done in the constructor
            and it is created once. Hence TC: O(max(a,b))
SC: O(n) - since dictionary is created to store indexes of all occurrences of each word
'''
import collections
from typing import List

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.hmap = collections.defaultdict(list)  
        for i, word in enumerate(wordsDict):
            self.hmap[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        if word1 not in self.hmap or word2 not in self.hmap:
            return -1
        l1 = self.hmap[word1]
        l2 = self.hmap[word2]
        i,j = 0,0
        gmin = float('inf')
        while i<len(l1) and j<len(l2):
            gmin = min(gmin, abs(l1[i]-l2[j]))
            if l1[i]<=l2[j]:
                i+=1
            else:
                j+=1
        return gmin

# Your WordDistance object will be instantiated and called as such:
obj = WordDistance(["practice","makes","perfect","coding","makes"])
param_1 = obj.shortest("coding","practice")
print(param_1)
param_2 = obj.shortest("makes","coding")
print(param_2)