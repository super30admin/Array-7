# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Boolean flag if the both the words are same then update index2 to index1


class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str,
                             word2: str) -> int:
        if not wordsDict:
            return None

        index1 = -1
        index2 = -1
        minDistance = inf
        if word1 == word2:
            flag = True
        else:
            flag = False
        for i in range(len(wordsDict)):
            if word1 == wordsDict[i]:
                if flag:
                    index2 = index1
                index1 = i
            elif word2 == wordsDict[i]:
                index2 = i
            if index1 != -1 and index2 != -1:
                minDistance = min(minDistance, abs(index2 - index1))
        return minDistance
