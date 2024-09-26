# 245. Shortest Word Distance III
# https://leetcode.com/problems/shortest-word-distance-iii/

# Logic:
# Less Efficient: Make a hashmap with the idx of the words and calculate distance.

# Efficient: Have 2 pointers and update them when corresponding word is found. 
# But if both the words are same, w2 becomes w1 everytime a new idx matches.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        w1 = -1
        w2 = -1
        minDist = inf
        
        for idx, i in enumerate(wordsDict):
            if i == word1:
                w1 = idx
            
                if word1 == word2:
                    w1 = w2
            
            if i == word2:
                w2 = idx

            if w1 != -1 and w2 != -1:
                minDist = min(minDist, abs(w1-w2))
        return minDist