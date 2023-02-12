class WordDistance:
    from collections import defaultdict
    ## T.C = O(m+n)
    ## S.C = O(n)
    
    def __init__(self, wordsDict: List[str]):
        self.wordsDict = wordsDict
        self.hm = defaultdict(list)
        self.build_hm()

    def build_hm(self):
        for i in range(len(self.wordsDict)):
            self.hm[self.wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        p1, p2 = 0, 0
        mn = float('inf')
        indices1 = self.hm[word1]
        indices2 = self.hm[word2]

        while p1 < len(indices1) and p2 < len(indices2):
            mn = min(mn, abs(indices1[p1] - indices2[p2]))
            if indices1[p1] < indices2[p2]:
                p1 += 1
            else:
                p2 += 1

        return mn



# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)