"""
Time Complexity: O(n) and O(m+n)
Space Complexity: O(n)
"""
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.locations = {}
        for i, word in enumerate(wordsDict):
            if word not in self.locations:
                self.locations[word] = []
            self.locations[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        
        loc1, loc2 = self.locations[word1], self.locations[word2]
        i, j = 0, 0
        min_dist = float('inf')

        while i < len(loc1) and j < len(loc2):
            min_dist = min(min_dist, abs(loc1[i] - loc2[j]))
            if loc1[i] < loc2[j]:
                i += 1
            else:
                j += 1

        return min_dist

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)