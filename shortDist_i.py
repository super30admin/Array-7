class Solution:
    
    """
    Description: distance between 2 distinct words in a given array of words
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach: 
    - initiate with a min distance (infinite) and indices for each word
    - update the distance and indices if words match when iterating through the entire array of words
    - return the minimum distance 
    """
    
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        indx1 = -1; indx2 = -1
        minDist = float("inf")
        
        for i in range(len(wordsDict)):
            
            if word1 == wordsDict[i]: indx1 = i
            if word2 == wordsDict[i]: indx2 = i
                
            if indx1 >= 0 and indx2 >= 0:
                minDist = min(minDist, abs(indx1 - indx2))
                
        return minDist
