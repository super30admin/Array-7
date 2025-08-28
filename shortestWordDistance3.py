# TimeComplexity:O(n)
# Space Complexity:O(1)
# Approach: Similar approach but words might be same so we need tofind distance among neighbours of same words we can use toggle to do that so that we ownt get 0 as distance evry time




class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        if word1==word2:
            l1,l2=-1,-1
            ans=float('inf')
            b=True
            for i in range(len(wordsDict)):
                if wordsDict[i]==word1 and b:
                    l1=i
                    b= False
                    if l2!=-1:
                        ans=min(ans, abs(l1-l2))
                elif wordsDict[i]==word2 and not b:
                    l2=i
                    b=True
                    if l1!=-1:
                        ans=min(ans,abs(l1-l2))
            return ans
                

        l1,l2=-1,-1
        ans=float('inf')
        for i in range(len(wordsDict)):
            if wordsDict[i]==word1:
                l1=i
                if l2!=-1:
                    ans=min(ans, abs(l1-l2))
            if wordsDict[i]==word2:
                l2=i
                if l1!=-1:
                    ans=min(ans,abs(l1-l2))
           
        return ans
        
