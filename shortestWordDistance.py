# Time Complexity : O(NM)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Iterate over the array and check if word1 and word2 are in wordsDict
# Initialize two variables index1 and index2 to -1 and update index of word1 to index1 and word2 to index2
# Take the minimum distance by getting the absolute value between index2 and index1 since the words can appear multiple times
# Return the minimum distance


class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str,
                         word2: str) -> int:
        if not wordsDict:
            return None
        minDistance = inf
        index1 = -1
        index2 = -1
        for i in range(len(wordsDict)):
            if word1 == wordsDict[i]:
                index1 = i
            elif word2 == wordsDict[i]:
                index2 = i
            if index1 != -1 and index2 != -1:
                minDistance = min(minDistance, abs(index2 - index1))
        return minDistance
