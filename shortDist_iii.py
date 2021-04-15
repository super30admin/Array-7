class Solution:
    
    """
    Description: distance between 2 words in a given array of words (words may be same)
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach: 
    - initiate with a min distance (infinite) and indices for each word
      + ensure the indices to take a turn when both words are same by creating a condition
    - update the distance and indices if words match when iterating through the entire array of words
    - return the minimum distance
    """
    
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        indx1 = -1; indx2 = -1
        minDist = float("inf")
        
        condition = word1 == word2
        
        for i in range(len(wordsDict)):
            
            if word1 == wordsDict[i]: 
                if condition: 
                    indx2 = indx1
                indx1 = i
                
            elif word2 == wordsDict[i]: indx2 = i
            
            if indx1 >= 0 and indx2 >= 0:
                minDist = min(minDist, abs(indx1 - indx2))
                
        return minDist
