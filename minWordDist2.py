class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.words = wordsDict
        self.indices = collections.defaultdict(list)
        for i in range(len(wordsDict)):
            self.indices[wordsDict[i]].append(i)
        
    def shortest(self, word1: str, word2: str) -> int:
        idx1 = self.indices[word1]
        idx2 = self.indices[word2]
        p1, p2 = 0, 0
        res = max(idx1[-1], idx2[-1])

        while p1 < len(idx1) and p2 < len(idx2):
            dist = abs(idx1[p1] - idx2[p2])
            res = min(res, dist)
            if idx1[p1] < idx2[p2]:
                p1 += 1
            else:
                p2 += 1
        return res

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)