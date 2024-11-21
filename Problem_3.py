class Solution(object):
    def shortestWordDistance(self, wordsDict, word1, word2):
        if wordsDict == None or len(wordsDict) == 0:
            return 0
        minDistance = float('inf')
        i1, i2 = -1, -1
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                i1 = i
            if wordsDict[i] == word2:
                if i1 == i:
                    i1 = i2
                i2 = i
            if i1 !=-1 and i2 !=-1:
                minDistance = min(minDistance, abs(i1-i2))
        return minDistance

# Time Complexity: O(n)
# Space Complexity: O(1)