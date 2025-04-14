from typing import List

class Solution:
    # TC : O(n)
    # SC : O(1)
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        
        index1 = index2 = -1
        shortest_distance = float('inf')
      
        for index, word in enumerate(wordsDict):
            if word == word1:
                index1 = index  
            if word == word2:
                index2 = index  
              
            # If both words have been found at least once, calculate the distance
            if index1 != -1 and index2 != -1:
                distance = abs(index1 - index2)  # Compute absolute difference
                shortest_distance = min(shortest_distance, distance)  # Update the shortest distance
      
        return shortest_distance