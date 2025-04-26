class WordDistance:
    # T: O(n), S: O(n)
    def __init__(self, wordsDict: List[str]):
        self.word_indices = defaultdict(list)
        for index, word in enumerate(wordsDict):
            self.word_indices[word].append(index)

    # T: O(w1 count + w2 count), S: O(1)
    def shortest(self, word1: str, word2: str) -> int:
        indices1 = self.word_indices[word1]
        indices2 = self.word_indices[word2]
        i, j = 0, 0
        min_dist = float("inf")
        while i < len(indices1) and j < len(indices2):
            index1, index2 = indices1[i], indices2[j]
            min_dist = min(min_dist, abs(index1 - index2))
            if index1 < index2:
                i += 1
            else:
                j += 1
        return min_dist


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
