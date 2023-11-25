""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        minn = float('inf')
        p1 = -1
        p2 = -1
        i1 = -1
        i2 = -1
        for i in range(len(wordsDict)):
            if word1 != word2:
                if wordsDict[i] == word1:
                    p1 = i
                elif wordsDict[i] == word2:
                    p2 = i
                if p1 != -1 and p2 != -1:
                    minn = min(minn, abs(p2-p1))
                if minn == 1:
                    return minn
            else:
                if wordsDict[i] == word1:
                    if i1 <= i2:
                        i1 = i
                    else:
                        i2 = i

                    if i1!=-1 and i2!= -1:
                        minn = min(minn,abs(i2-i1))

        return minn