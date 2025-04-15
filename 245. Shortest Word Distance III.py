#time:O(n)
#space:O(1)
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        w1_idx= float('inf')
        w2_idx= float('inf')
        mnm= float('inf')
        n= len(wordsDict)

        for i in range(n):
            if wordsDict[i] == word1:
                w1_idx= i
            if wordsDict[i] == word2:
                if w1_idx == i:
                    w1_idx=w2_idx
                w2_idx=i
            mnm= min(mnm, abs(w1_idx-w2_idx))
        return mnm
        
