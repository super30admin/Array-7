# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap to store the list of indices and then using two pointer approach to get the minimumDistance
# Where one pointer i is at start of list1 and another pointer j is at start of list2
# If value at index i < val at index j then increment i else increment j so time complexity would be max(list1, list2)

from collections import defaultdict


class WordDistance:
    def __init__(self, wordsDict: List[str]):
        self.wordsDict = wordsDict
        self.dict = defaultdict()
        for i in range(len(self.wordsDict)):
            if self.wordsDict[i] not in self.dict:
                self.dict[self.wordsDict[i]] = [i]
            else:
                self.dict[self.wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        list1 = []
        list2 = []
        distance = 1
        minDistance = inf
        list1 = self.dict[word1]
        list2 = self.dict[word2]
        i = 0
        j = 0
        while i < len(list1) and j < len(list2):
            val1 = list1[i]
            val2 = list2[j]
            minDistance = min(minDistance, abs(val2 - val1))
            if val1 < val2:
                i += 1
            else:
                j += 1
        return minDistance


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)