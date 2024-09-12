# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        i1 , i2 = -1, -1 
        res = float('inf')
        for i in range(len(words)):
            if word1 == word2:
                if words[i] == word2 and i2 == -1:
                    i2 = i 
                elif words[i] == word2:
                    i1 = i2 
                    i2 = i 
                    res = min(res, abs(i1 - i2))
                
            else:
                if words[i] == word2:
                    i2 = i 

                if words[i] == word1:
                    i1 = i 

                if i1 != -1 and i2 != -1:
                    res = min(res, abs(i1 -i2))
        
        return res