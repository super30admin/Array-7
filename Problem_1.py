"""
Time Complexity : O(n) 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

This is just a 2 pointer approach, in which we compare every word we encounter with our 2 words and modify the pointers
simultaneously and find the minimum distance.
"""


class Solution:
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        i1, i2 = -1, -1
        minimum = inf
        for i in range(len(words)):
            if words[i] == word1:
                i1 = i
            if words[i] == word2:
                i2 = i
            if i1 != -1 and i2 != -1:
                minimum = min(minimum, abs(i2-i1))
        return minimum
