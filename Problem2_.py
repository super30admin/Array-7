# TC:O(m+n) where m and n are occurances of both word.
# constructor TC will be O(n) where n is the number of words
# SC:O(n) where n is the number of words

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.map = {}
        for index, word in enumerate(wordsDict):
            if word not in self.map:
                self.map[word] = []

            self.map[word].append(index)

    def shortest(self, word1: str, word2: str) -> int:
        l1 = self.map[word1]
        l2 = self.map[word2]
        _min = sys.maxsize
        i = 0
        j = 0
        while i < len(l1) and j < len(l2):
            _min = min(_min, abs(l1[i] - l2[j]))

            if l1[i] < l2[j]:
                i += 1
            else:
                j += 1

        return _min

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)