#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        l1=-1
        l2=-1
        minRes=float('inf')
        for i in range(len(wordsDict)):
            if wordsDict[i]==word1:
                l1=i
            if wordsDict[i]==word2:
                if l1==i:
                    l1=l2
                l2=i
            if l1!=-1 and l2!=-1:
                minRes=min(minRes,abs(l1-l2)) 
        return minRes
        