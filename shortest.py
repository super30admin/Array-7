class WordDistance:
    def __init__(self, wordsDict: List[str]):
        self.wordsDict = wordsDict
        self.locations = defaultdict(list)
        # Prepare a mapping from a word to all it's locations (indices).
        for i, w in enumerate(wordsDict):
            self.locations[w].append(i)
        # print(self.locations)

    def shortest(self, word1: str, word2: str) -> int:
        loc1, loc2 = self.locations[word1], self.locations[word2]
        l1, l2 = 0, 0
        min_diff = float("inf")

        # Until the shorter of the two lists is processed
        while l1 < len(loc1) and l2 < len(loc2):
            min_diff = min(min_diff, abs(loc1[l1] - loc2[l2]))
            if loc1[l1] < loc2[l2]:
                l1 += 1
            else:
                l2 += 1
        return min_diff
    
    def bruteForceshortest(self, word1: str, word2: str) -> int:
        l, r = -1, -1
        dist = len(self.wordsDict)
        # print("self.wordsDict", self.wordsDict  )
        for idx, word in enumerate(self.wordsDict):
            if word == word1:
                l = idx
            elif word == word2:
                r = idx
            if l != -1 and r != -1:
                dist = min(dist , abs(l-r))
        return dist
        


# Your WordDistance object will be instantiated and called as such:
# param_1 = obj.shortest(word1,word2)



