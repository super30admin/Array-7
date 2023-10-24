class WordDistance:
    def __init__(self, wordsDict: List[str]):
        self.locations = defaultdict(list) #build a dictinary of all words' indices in thier own lists

        for i, w in enumerate(wordsDict):
            self.locations[w].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        loc1, loc2 = self.locations[word1], self.locations[word2] #get the list for the words asked
        l1, l2 = 0, 0
        min_diff = float("inf")
        while l1 < len(loc1) and l2 < len(loc2): #now youhave 2 sorted lists with different indices, need to get shortest distance betweeen these numbers -> o(n^2) is to use 2 for loops, but instead use 2 pointers and move the pointer of the smaller number -> O(n)
            min_diff = min(min_diff, abs(loc1[l1] - loc2[l2]))
            if loc1[l1] < loc2[l2]:
                l1 += 1
            else:
                l2 += 1
        return min_diff


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)