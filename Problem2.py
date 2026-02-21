class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.dict = defaultdict(list)
        for i, word in enumerate(wordsDict):
            self.dict[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        i, j = 0,0
        mini= float('inf')
        lst1, lst2 = self.dict[word1], self.dict[word2]
        while i < len(lst1) and j < len(lst2):
            mini = min(mini, abs(lst1[i]-lst2[j]))

            if lst1[i] < lst2[j]:
                i += 1
            else:
                j += 1

        return mini


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
