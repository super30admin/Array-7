# Problem 1 : Shortest Word Distance
# Time Complexity : O(n) where n is the length of the wordsDict list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

from typing import List
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # edge case where the list wordsDict is None or length is 0 then return -1
        if wordsDict is None or len(wordsDict) == 0:
            return -1
        # define two variables which will store the index for word1 and word2
        i1 = -1
        i2 = -1
        # define minDist which will store the minimum distance between two word1 and word2
        minDist = float('inf')
        # loop through the list of wordsDict
        for i in range(len(wordsDict)):
            # get the ith word of wordsDict
            currentString = wordsDict[i]
            # check if the current string is equal to word1 and if it is then store value of i in the i1
            if currentString == word1:
                i1 = i
            # check if the current string is equal to word2 and if it is then store value of i in the i2
            if currentString == word2:
                i2 = i
            # check the value of i1 and i2 are not equal to -1 and if it is then get the difference and store minimum between this value and minDist in minDist
            if i1 != -1 and i2 != -1:
                minDist = min(minDist, abs(i1- i2))
        # return minDist as answer
        return minDist
