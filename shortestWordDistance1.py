#TimeComplexity:  O(n)
#SpaceCompelxity:O(1)
#Approach:
# ask followup question are words repeated can word1 and word2 be same , bruteforce would froevery occurene of word1 find distace for every word2
# but this can be optimized by just calculating distacen between neighbours





class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
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
            if l1!=-1 and l2!=-1:
                return ans
        return ans

