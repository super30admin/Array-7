'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Create a hashmap and in the hashmap for each word keep a list of all the indexes.
When a query comes in get the list of indexes for the words from the hashmap.
Since the indexes are sorted we can use 2 pointer approach to get the minimum distance.
'''

class WordDistance:

    def __init__(self, words: List[str]):
        self.map = {}
        for i in range(0, len(words)):
            if words[i] in self.map:
                self.map[words[i]].append(i)
            else:
                self.map[words[i]] = [i]

    def shortest(self, word1: str, word2: str) -> int:
        i1 = self.map.get(word1)
        i2 = self.map.get(word2)

        minDistance = math.inf
        i = j = 0
        while i < len(i1) and j < len(i2):
            minDistance = min(minDistance, abs(i1[i] - i2[j]))
            if i1[i] < i2[j]:
                i += 1
            else:
                j += 1

        return minDistance

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)