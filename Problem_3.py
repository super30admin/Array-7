"""
Time Complexity : O(n) 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

This is similar to shortest word distance 1 , just that words can be same. Again, this is just a 2 pointer approach, in which we 
compare every word we encounter with our 2 words and modify the pointers simultaneously and find the minimum distance. The only 
difference being, if we see that the word is same(i.e., the previous pointer was also updated), then we modify the previous pointer
with previous value of current pointer.
"""


class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        i1, i2 = -1, -1
        minimum = inf
        for i in range(len(words)):
            if words[i] == word1:
                i1 = i
            if words[i] == word2:
                if i1 == i:
                    i1 = i2
                i2 = i
            if i1 != -1 and i2 != -1:
                minimum = min(minimum, abs(i2-i1))
        return minimum
