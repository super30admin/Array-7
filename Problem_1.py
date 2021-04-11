# Time Complexity: O(N)
# Space Complexity: O(1)

class Solution(object):
    def shortestDistance(self, wordsDict, word1, word2):
        index1 = -1
        index2 = -1
        minimum = float("inf")
        
        for i in range(len(wordsDict)):
            if word1 == wordsDict[i]:
                index1 = i
            if word2 == wordsDict[i]:
                index2 = i
            
            if index1 != -1 and index2 != -1:
                minimum = min(minimum, abs(index2 - index1))
        return minimum
        
