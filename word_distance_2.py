# Time Complexity: O(n)
# Space Complexity: O(1)

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.words = wordsDict
        self.map = defaultdict(list)
        for i, word in enumerate(self.words):
            self.map[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        list1 = self.map[word1]
        list2 = self.map[word2]
        p1 = p2 = 0
        profit = 2**32
        # print(list1, list2)
        while p1 < len(list1) and p2 < len(list2):
            profit = min(profit, abs(list1[p1]-list2[p2]))
            if list1[p1] < list2[p2]:
                p1 += 1
            else:
                p2 += 1
        return profit

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
