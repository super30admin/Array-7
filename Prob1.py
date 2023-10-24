class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        #Method 1 - one pass - just use pointers to keep track of each indices and update the mindist each time.
        #TC O(n)
        
        p1=-1
        p2=-1
        mindist=len(wordsDict)
        for i in range(len(wordsDict)):
            if wordsDict[i]==word1:
                p1=i
            if wordsDict[i]==word2:
                p2=i
            if p1!=-1 and p2!=-1:
                mindist=min(mindist,abs(p2-p1))
        return mindist


