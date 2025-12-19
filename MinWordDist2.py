# Time is O(n) for init constructor. Space is O(m+n) for shortest method.

# The intuition here is to use a hashmap to keep the list of index for that word.
# Then using two pointers we can calculate shorted distance between them

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.hashmap = defaultdict(list)
        for idx, word in enumerate(wordsDict):
            self.hashmap[word].append(idx)

    def shortest(self, word1: str, word2: str) -> int:
        list1 = self.hashmap[word1]
        list2 = self.hashmap[word2]
        p1 = 0
        p2 = 0
        minDist = float("inf")
        while p1 < len(list1) and p2 < len(list2):
            minDist = min(minDist, abs(list1[p1] - list2[p2]))
            if list1[p1] < list2[p2]:
                p1 += 1
            else:
                p2 += 1
        return minDist
# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)