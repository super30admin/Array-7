# TIme Complexity - O(N*l)
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = p2 = -1
        min_val = sys.maxsize
        if word1 == word2:
            for i, word in enumerate(wordsDict):
                if word == word1:
                    p2 = p1
                    p1 = i
                        
                if p1 != -1 and p2 != -1 :
                    min_val = min(min_val, abs(p1-p2))

        else:
            for i, word in enumerate(wordsDict):
                if word == word1:
                    p1 = i
                if word == word2:
                    if p1 == i:
                        p2 = p1
                        p1 = i
                    else:
                        p2 = i
                if p1 != -1 and p2 != -1:
                    min_val = min(min_val, abs(p1-p2))
        return min_val
        
