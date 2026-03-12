# Time Complexity : O(N) preprocessing, O(M+N) per query
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Preprocess the word list and store indices for each word.
# For a query, use two pointers to find the minimum distance
# between the two index lists.

from collections import defaultdict

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        
        self.map = defaultdict(list)
        
        for i, word in enumerate(wordsDict):
            self.map[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        
        l1 = self.map[word1]
        l2 = self.map[word2]
        
        i = j = 0
        res = float('inf')
        
        while i < len(l1) and j < len(l2):
            
            res = min(res, abs(l1[i] - l2[j]))
            
            if l1[i] < l2[j]:
                i += 1
            else:
                j += 1
        
        return res