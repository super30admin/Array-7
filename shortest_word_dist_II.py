class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.hmap = defaultdict(list)
        for i,word in enumerate(wordsDict):
            self.hmap[word].append(i)

    # Time complexity - O(k1 +k2) where k1 and k2 are the lengths of l1 and l2
    def shortest(self, word1: str, word2: str) -> int:
        l1 = self.hmap.get(word1)
        l2 = self.hmap.get(word2)
        min_val = sys.maxsize
        p1 = p2 = 0
        while (p1 < len(l1) and p2 < len(l2)):
            min_val = min(min_val, abs(l1[p1]-l2[p2]))
            if l1[p1] < l2[p2]:
                p1 += 1
            else:
                p2 += 1
        return min_val


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
