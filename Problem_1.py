class Solution(object):
    def shortestDistance(self, wordsDict, word1, word2):
        if wordsDict == None or len(wordsDict) == 0:
            return 0
        i1, i2 = -1, -1
        minDistance = len(wordsDict)
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                i1 = i
            if wordsDict[i] == word2:
                i2 = i
            if i1!= -1 and i2 !=-1:
                minDistance = min(minDistance, abs(i2-i1))
        return minDistance
        
# Time Complexity: O(n)
# Space Complexity: O(1)