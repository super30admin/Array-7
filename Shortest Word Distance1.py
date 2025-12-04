# Time Complexity : O(N) where N is number of elements in wordsDict
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using two pointers to keep track of the latest indices of word1 and word2 as I iterate through the wordsDict.
# Whenever I find either word, I update its index and check if both indices are valid to compute the distance.
# I update the minimum distance found so far and return it at the end.
from typing import List
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        i = -1
        j = -1
        ans = float('inf')
        for idx,word in enumerate(wordsDict):
            if word == word1:
                i = idx
            if word == word2:
                j = idx
            if i != -1 and j != -1:
                ans = min(ans,abs(i-j))
        return ans