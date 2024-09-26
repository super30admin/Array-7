"""
TC: O(n)
SC: O(n) ignoring the constructor
"""
from collections import defaultdict
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        """
        TC: O(n)
        SC: O(n)
        """
        self.idx = defaultdict(list)
        for i in range(len(wordsDict)):
            self.idx[wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        min_ = float('inf')
        ptr1 = 0
        ptr2 = 0
        list1 = self.idx[word1]
        list2 = self.idx[word2]
        while ptr1 < len(list1) and ptr2 < len(list2):
            min_ = min(min_, abs(list1[ptr1] - list2[ptr2]))
            if list1[ptr1] < list2[ptr2]:
                ptr1 += 1
            else:
                ptr2 += 1
        return min_


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)