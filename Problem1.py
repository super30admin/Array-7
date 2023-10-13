#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        l1=-1
        l2=-1
        res=float("inf")
        for i in range(len(wordsDict)):
            if wordsDict[i]==word1:
                l1=i
            if wordsDict[i]==word2:
                l2=i
            if l1!=-1 and l2!=-1:
                res=min(res,abs(l1-l2))
        return res                
        