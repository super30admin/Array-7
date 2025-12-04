# Time Complexity : O(N) where N is number of elements in wordsDict
# Space Complexity : O(N) where N is number of elements in wordsDict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am pre-processing the wordsDict to create a hashmap that maps each word to a list of its indices.
# This allows for efficient retrieval of indices for any given word.
# The shortest method uses a two-pointer technique to find the minimum distance between the indices of the two words.
# By iterating through both lists of indices, I can efficiently compute the minimum distance.
# This approach ensures that the distance calculation is optimal.
from typing import List
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.hashmap = {}
        for i in range(len(wordsDict)):
            w = wordsDict[i]
            if w not in self.hashmap:
                self.hashmap[w] = []
            self.hashmap[w].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        arr1 = self.hashmap[word1]
        arr2 = self.hashmap[word2]
        i = 0
        j = 0
        ans = float('inf')
        while i < len(arr1) and j < len(arr2):
            ans = min(ans,abs(arr1[i]-arr2[j]))
            if arr1[i] < arr2[j]:
                i += 1
            else:
                j += 1
        return ans
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)