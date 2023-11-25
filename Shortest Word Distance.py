""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        minn = float('inf')
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                p1 = i
            elif wordsDict[i] == word2:
                p2 = i
            if p1 != -1 and p2 != -1:
                minn = min(minn, abs(p2-p1))
            if minn == 1:
                return minn
        return minn