class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        w1 , w2 = None, None
        l, r = -1, -1
        dist = len(wordsDict)
        for idx, word in enumerate(wordsDict):
            if word == word1:
                l = idx
            elif word == word2:
                r = idx
            if l != -1 and r != -1 :
                dist = min( dist, abs(l-r)  )
        return dist
