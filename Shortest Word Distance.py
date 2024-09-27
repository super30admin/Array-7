class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        #Approach: Single forward pass
        #Time Complexity: O(n * l)
        #Space Complexity: O(1)
        #where, n is the number of words in wordsDict
        #and, l is the average length of word1 and word2
        
        idx1 = -inf
        idx2 = inf
        
        minDist = inf
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                idx1 = i
            elif wordsDict[i] == word2:
                idx2 = i
            minDist = min(minDist, abs(idx1 - idx2))
            
        return minDist