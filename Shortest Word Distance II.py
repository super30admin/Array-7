class WordDistance:

    def __init__(self, wordsDict: List[str]): # O(n)
        self.dic = defaultdict(list)
        for word in range(len(wordsDict)):
            self.dic[wordsDict[word]].append(word)

    def shortest(self, word1: str, word2: str) -> int: # O(n)
        w1 = 0
        w2 = 0
        dist = float('inf')
        w1list = self.dic[word1]
        w2list = self.dic[word2]
        while w1 < len(w1list) and w2 < len(w2list):
            dist = min(dist, abs(w1list[w1] - w2list[w2]))
            if w1list[w1] < w2list[w2]: w1 += 1
            else: w2 += 1
        return dist




# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)