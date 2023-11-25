# Time Complexity : O(n*L)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # declare the default variables
        p1, p2, min_val = -1, -1, float('inf')
        
        # traverse over the words in the dict and maintain a index pointer i
        for i, word in enumerate(wordsDict):
            # if the first word matches with the current word then update the value of p1
            if word == word1:
                p1 = i
            # if the second word matches with the current word then update the value of p2
            elif word == word2:
                p2 = i
            
            # if both the words are found, then find the min
            if p1 != -1 and p2 != -1:
                min_val = min(min_val,abs(p1-p2))
        
        # return the minimum difference found between words
        return min_val
