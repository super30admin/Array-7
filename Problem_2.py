"""
Time Complexity : O(n + j+ k)- Here n is the number of words and we created a hashmap for all the words. j+k is for doing
2 pointer approach on the list of locations 
Space Complexity : O(n)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

We first iterate through the word list and make a hashmap for locations of all the words. As this would be done only once, so
this won't matter that much. Next, whenever we get the 2 words, we just take the location lists of those words and perform
a 2 pointer approach on the locations to find minimum distance.
"""

from collections import defaultdict


class WordDistance:

    def __init__(self, words: List[str]):
        self.wordMap = defaultdict(list)
        for i in range(len(words)):
            self.wordMap[words[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        list1 = self.wordMap[word1]
        list2 = self.wordMap[word2]
        minimum = inf
        p1, p2 = 0, 0
        while p1 < len(list1) and p2 < len(list2):
            val1 = list1[p1]
            val2 = list2[p2]
            minimum = min(minimum, abs(val1-val2))
            if val1 < val2:
                p1 += 1
            else:
                p2 += 1
        return minimum


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)
