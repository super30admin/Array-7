class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:

        ind1, ind2, res = -1, -1, math.inf
        same = False
        if word1==word2:
            same = True
        for i in range(len(wordsDict)):
            if same and wordsDict[i]==word1:
                ind2 = ind1
                ind1 = i
            elif wordsDict[i]==word1:
                ind1 = i
            elif wordsDict[i]==word2:
                ind2 = i

            if ind2>=0 and ind1>=0:
                res = min(res, abs(ind1-ind2))

        return res

             
                