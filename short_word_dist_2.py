# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.i_map = {}
        for i in range(len(wordsDict)):
            word = wordsDict[i]
            if word not in self.i_map:
                self.i_map[word] = []
            self.i_map[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        ilw1,ilw2 = self.i_map[word1], self.i_map[word2]
        p1,p2 = 0,0
        res = float('inf')

        while p1 < len(ilw1) and p2 < len(ilw2):
            dist = abs(ilw1[p1] - ilw2[p2])
            res = min(res, dist)
            if ilw1[p1] < ilw2[p2]:
                p1 += 1
            else:
                p2 += 1
        
        return res
        
# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)